package com.example.feature_air_ticket_presentation.fragment.ui.show_flights

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.feature_air_ticket_data.data_source.MainScreenDataSourceImpl
import com.example.feature_air_ticket_data.repository.MainScreenRepositoryImpl
import com.example.feature_air_ticket_domain.use_case.get_direct_flight_list.GetDirectFlightListUseCaseImpl
import com.example.feature_air_ticket_presentation.R
import com.example.feature_air_ticket_presentation.databinding.FragmentShowFlightsBinding
import com.example.feature_air_ticket_presentation.fragment.ui.show_flights.adapter.DirectFlightAdapter
import com.example.feature_air_ticket_presentation.fragment.ui.show_flights.model.TravelData
import com.example.feature_air_ticket_presentation.fragment.utils.Constants
import com.example.feature_air_ticket_presentation.fragment.utils.Constants.DATE_FORMAT_SHORTENED_MONTH
import com.example.feature_air_ticket_presentation.fragment.utils.Constants.DATE_PICKER_TAG
import com.example.feature_air_ticket_presentation.fragment.utils.Constants.DATE_PICKER_TITLE
import com.example.feature_air_ticket_presentation.fragment.utils.Constants.DEPARTURE_DESTINATION_TEXT_KEY
import com.example.feature_air_ticket_presentation.fragment.utils.Constants.GREY_SYMBOL_COUNT
import com.example.feature_air_ticket_presentation.fragment.utils.Constants.TRAVEL_DATA_KEY
import com.example.feature_air_ticket_presentation.fragment.utils.Constants.TRAVEL_DATA_RESULT
import com.example.feature_air_ticket_presentation.fragment.utils.factories.ShowFlightsViewModelFactory
import com.example.feature_air_ticket_presentation.fragment.utils.getFormattedDate
import com.google.android.material.chip.Chip
import com.google.android.material.datepicker.MaterialDatePicker
import ui.BaseFragment
import java.util.Date

class ShowFlightsFragment : BaseFragment() {

    private var _binding: FragmentShowFlightsBinding? = null
    private val binding get() = _binding
    private var departureDate: Long? = null

    //TODO: временное решение, переделать на Даггер
    private val viewModel by lazy {
        ViewModelProviders.of(
            this, ShowFlightsViewModelFactory(
                GetDirectFlightListUseCaseImpl(
                    MainScreenRepositoryImpl(
                        MainScreenDataSourceImpl()
                    )
                )
            )
        ).get(ShowFlightsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ConstraintLayout? {

        _binding = FragmentShowFlightsBinding.inflate(inflater, container, false)
        val root = binding?.root

        getFragmentResult()
        setDate()
        setDirectFlightRecycler()
        setTownText()
        setClickListeners()

        return root
    }

    private fun setClickListeners() {
        binding?.apply {
            ivChange.setOnClickListener {
                val departureText = tvFrom.text
                val destinationText = tvWhere.text
                tvFrom.text = destinationText
                tvWhere.text = departureText
            }
            ivBack.setOnClickListener {
                findNavController().popBackStack()
            }
            chipBack.setOnClickListener { view ->
                chooseFlightDate(view)
            }
            chipDate.setOnClickListener { view ->
                chooseFlightDate(view)
            }
            btnAllTickets.setOnClickListener {
                setTravelData()
                findNavController().apply {
                    navigate(R.id.action_airShowFlights_to_allTicketsFragment)
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setDate() {
        val date = Date().time
        val dateText = getFormattedDate(date, DATE_FORMAT_SHORTENED_MONTH)
        departureDate = date
        val coloredText = SpannableString(dateText)
        coloredText.setSpan(
            ForegroundColorSpan(resources.getColor(com.example.ui.R.color.grey_6)),
            dateText.length - GREY_SYMBOL_COUNT, dateText.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding?.chipDate?.text = coloredText
    }

    private fun setDirectFlightRecycler() {
        viewModel.getDirectFlightList()
        viewModel.directFlightsLiveData.observe(viewLifecycleOwner) { list ->
            binding?.rvDirectFlights?.apply {
                layoutManager = LinearLayoutManager(
                    requireActivity(),
                    LinearLayoutManager.VERTICAL,
                    false
                )
                adapter = DirectFlightAdapter(list)
            }
        }
    }

    private fun getFragmentResult() {
        requireActivity().supportFragmentManager.setFragmentResultListener(
            Constants.DEPARTURE_DESTINATION_TEXT_RESULT,
            viewLifecycleOwner
        ) { _, bundle ->
            val townNames =
                bundle.getSerializable(DEPARTURE_DESTINATION_TEXT_KEY) as? Pair<String, String>
            townNames?.let {
                viewModel.setTownNames(it)
            }
        }
    }

    private fun setTownText() {
        binding?.apply {
            viewModel.townNamesLiveData.observe(viewLifecycleOwner) { townNames ->
                tvFrom.text = townNames?.first.toString()
                tvWhere.text = townNames?.second.toString()
            }
        }
    }



    private fun chooseFlightDate(view: View) {
        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText(DATE_PICKER_TITLE)
                .build()
        datePicker.show(
            childFragmentManager,
            DATE_PICKER_TAG
        )
        datePicker.addOnPositiveButtonClickListener { date ->
            departureDate = date
            (view as Chip).text = getFormattedDate(date, DATE_FORMAT_SHORTENED_MONTH)
        }
    }

    private fun setTravelData() {
        binding?.apply {
            val travelData = TravelData(
                departure = tvFrom.text.toString(),
                destination = tvWhere.text.toString(),
                departureDate = departureDate ?: 0
            )
            requireActivity().supportFragmentManager.setFragmentResult(
                TRAVEL_DATA_RESULT,
                bundleOf(TRAVEL_DATA_KEY to travelData)
            )
        }
    }

    private fun getViewModel() {

    }
}
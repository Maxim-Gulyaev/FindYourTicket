package com.example.feature_air_ticket_presentation.fragment.ui.show_flights

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.feature_air_ticket_data.data_source.MainScreenDataSourceImpl
import com.example.feature_air_ticket_data.repository.MainScreenRepositoryImpl
import com.example.feature_air_ticket_domain.use_case.get_music_offer_list.GetDirectFlightListUseCaseImpl
import com.example.feature_air_ticket_presentation.R
import com.example.feature_air_ticket_presentation.databinding.FragmentShowFlightsBinding
import com.example.feature_air_ticket_presentation.fragment.ui.show_flights.adapter.DirectFlightAdapter
import com.example.feature_air_ticket_presentation.fragment.utils.Constants
import com.example.feature_air_ticket_presentation.fragment.utils.Constants.DATE_FORMAT
import com.example.feature_air_ticket_presentation.fragment.utils.Constants.DATE_PICKER_TAG
import com.example.feature_air_ticket_presentation.fragment.utils.Constants.DATE_PICKER_TITLE
import com.example.feature_air_ticket_presentation.fragment.utils.Constants.DEPARTURE_DESTINATION_TEXT_KEY
import com.example.feature_air_ticket_presentation.fragment.utils.Constants.EMPTY_STRING
import com.example.feature_air_ticket_presentation.fragment.utils.Constants.RU_COUNTRY
import com.example.feature_air_ticket_presentation.fragment.utils.Constants.RU_LANGUAGE
import com.example.feature_air_ticket_presentation.fragment.utils.ShowFlightsViewModelFactory
import com.google.android.material.chip.Chip
import com.google.android.material.datepicker.MaterialDatePicker
import ui.BaseFragment
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ShowFlightsFragment : BaseFragment() {

    //TODO: rid this horrible code using Dagger
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

    private var _binding: FragmentShowFlightsBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ConstraintLayout? {

        _binding = FragmentShowFlightsBinding.inflate(inflater, container, false)
        val root = binding?.root

        setDateInChip()
        setDirectFlightRecycler()
        setDestinationDepartureText()
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
            chipBack.setOnClickListener { view ->
                chooseFlightDate(view)
            }
            chipDate.setOnClickListener { view ->
                chooseFlightDate(view)
            }
            btnAllTickets.setOnClickListener {
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

    private fun setDateInChip() {
        val date = Date().time
        val dateText = getFormattedDate(date)
        val editableText = Editable.Factory.getInstance().newEditable(dateText)
        binding?.chipDate?.text = editableText
    }

    private fun setDirectFlightRecycler() {
        viewModel.getDirectFlightList()
        viewModel.directFlightList.observe(viewLifecycleOwner) { list ->
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

    private fun setDestinationDepartureText() {
        requireActivity().supportFragmentManager.setFragmentResultListener(
            Constants.DEPARTURE_DESTINATION_TEXT_RESULT,
            viewLifecycleOwner
        ) { _, bundle ->
            val destinationDepartureText =
                bundle.getSerializable(DEPARTURE_DESTINATION_TEXT_KEY) as? Pair<*, *>
            binding?.apply {
                tvFrom.text = destinationDepartureText?.first.toString()
                tvWhere.text = destinationDepartureText?.second.toString()
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
            (view as Chip).text = getFormattedDate(date)
        }
    }

    private fun getFormattedDate(date: Long): String =
        SimpleDateFormat(DATE_FORMAT, Locale(RU_LANGUAGE, RU_COUNTRY))
            .format(Date(date))
            .replace(".", EMPTY_STRING)

}
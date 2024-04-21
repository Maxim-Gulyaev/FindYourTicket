package com.example.feature_air_ticket_presentation.fragment.ui.main_screen

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.feature_air_ticket_data.data_source.MainScreenDataSourceImpl
import com.example.feature_air_ticket_data.repository.MainScreenRepositoryImpl
import com.example.feature_air_ticket_domain.use_case.get_music_offer_list.GetMusicOfferListUseCaseImpl
import com.example.feature_air_ticket_presentation.databinding.FragmentAirTicketMainBinding
import com.example.feature_air_ticket_presentation.fragment.ui.main_screen.adapter.MusicOfferAdapter
import com.example.feature_air_ticket_presentation.fragment.ui.main_screen.bottom_sheet.BottomSheetFragment
import com.example.feature_air_ticket_presentation.fragment.ui.main_screen.model.MusicOffer
import com.example.feature_air_ticket_presentation.fragment.utils.Constants.BOTTOM_SHEET
import com.example.feature_air_ticket_presentation.fragment.utils.Constants.DEPARTURE_TEXT_KEY
import com.example.feature_air_ticket_presentation.fragment.utils.Constants.DEPARTURE_TEXT_RESULT
import com.example.feature_air_ticket_presentation.fragment.utils.Constants.EMPTY_STRING
import com.example.feature_air_ticket_presentation.fragment.utils.view_model_factory.MainFragmentViewModelFactory
import com.example.feature_air_ticket_presentation.fragment.utils.SharedPreferences
import ui.BaseFragment

class AirTicketsMainFragment : BaseFragment() {

    //TODO rid this horrible code using Dagger
    private val viewModel by lazy {
        ViewModelProviders.of(
            this, MainFragmentViewModelFactory(
                GetMusicOfferListUseCaseImpl(
                    MainScreenRepositoryImpl(
                        MainScreenDataSourceImpl()
                    )
                )
            )
        ).get(AirTicketsMainViewModel::class.java)
    }

    private var _binding: FragmentAirTicketMainBinding? = null
    private val binding get() = _binding
    private var sharedPreferences: SharedPreferences? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ConstraintLayout? {
        _binding = FragmentAirTicketMainBinding.inflate(inflater, container, false)
        sharedPreferences = SharedPreferences(requireActivity())

        setPersistedInput()
        setInputListener()
        getMusicOfferList()

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setInputListener() {
        binding?.apply {
            tvDeparture.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable?) {
                    sharedPreferences?.saveInput(tvDeparture.text.toString())
                }

            })
            etWhere.setOnClickListener {
                setFragmentResult()
                val bottomSheet = BottomSheetFragment()
                bottomSheet.show(childFragmentManager, BOTTOM_SHEET)
            }

        }
    }

    private fun setPersistedInput() {
        binding?.tvDeparture?.setText(sharedPreferences?.getInput() ?: EMPTY_STRING)
    }

    private fun getMusicOfferList() {
        viewModel.getMusicOffersList()
        viewModel.musicOfferList.observe(viewLifecycleOwner) { list ->
            setMusicOfferRecycler(list)
        }
    }

    private fun setMusicOfferRecycler(offerList: List<MusicOffer>) {
        binding?.rvMusicOffer?.apply {
            layoutManager = LinearLayoutManager(
                requireActivity(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
            adapter = MusicOfferAdapter(offerList)
        }
    }

    private fun setFragmentResult() {
        val departureText = binding?.tvDeparture?.text
        requireActivity().supportFragmentManager.setFragmentResult(
            DEPARTURE_TEXT_RESULT,
            bundleOf(Pair(DEPARTURE_TEXT_KEY, departureText))
        )
    }
}
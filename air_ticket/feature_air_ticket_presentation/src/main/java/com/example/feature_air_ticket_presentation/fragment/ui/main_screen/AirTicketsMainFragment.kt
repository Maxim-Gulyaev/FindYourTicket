package com.example.feature_air_ticket_presentation.fragment.ui.main_screen

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProviders
import com.example.feature_air_ticket_data.data_source.MainScreenDataSourceImpl
import com.example.feature_air_ticket_data.repository.MainScreenRepositoryImpl
import com.example.feature_air_ticket_domain.use_case.get_music_offer_list.GetMusicOfferListUseCaseImpl
import com.example.feature_air_ticket_presentation.databinding.FragmentAirTicketMainBinding
import com.example.feature_air_ticket_presentation.fragment.utils.MainFragmentViewModelFactory
import com.example.feature_air_ticket_presentation.fragment.utils.SharedPreferences
import ui.BaseFragment

class AirTicketsMainFragment: BaseFragment() {

    //TODO rid this horrible code using Dagger
    private val viewModel by lazy {
        ViewModelProviders.of(this, MainFragmentViewModelFactory(GetMusicOfferListUseCaseImpl(
            MainScreenRepositoryImpl(MainScreenDataSourceImpl())
        ))).get(AirTicketsMainViewModel::class.java)
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

        setMusicOfferRecycler()

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setInputListener() {
        binding?.apply {
            etFrom.addTextChangedListener( object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable?) {
                    sharedPreferences?.saveInput(etFrom.text.toString())
                }

            })
        }
    }

    private fun setPersistedInput() {
        binding?.etFrom?.setText(sharedPreferences?.getInput() ?: "")
    }

    private fun setMusicOfferRecycler() {
        viewModel.getMusicOffersList()
        viewModel.musicOfferList.observe(viewLifecycleOwner) {
            Log.i("maxlog", it.toString())
        }
    }
}
package com.example.feature_air_ticket_presentation.fragment.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.feature_air_ticket_presentation.databinding.FragmentAirTicketMainBinding
import com.example.feature_air_ticket_presentation.fragment.utils.SharedPreferences
import ui.BaseFragment

class AirTicketsMainFragment: BaseFragment() {

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
}
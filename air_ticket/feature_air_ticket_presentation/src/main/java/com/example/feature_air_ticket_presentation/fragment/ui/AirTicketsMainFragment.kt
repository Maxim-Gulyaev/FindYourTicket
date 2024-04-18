package com.example.feature_air_ticket_presentation.fragment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.feature_air_ticket_presentation.databinding.FragmentAirTicketMainBinding
import ui.BaseFragment

class AirTicketsMainFragment: BaseFragment() {

    private var _binding: FragmentAirTicketMainBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ConstraintLayout? {

        _binding = FragmentAirTicketMainBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
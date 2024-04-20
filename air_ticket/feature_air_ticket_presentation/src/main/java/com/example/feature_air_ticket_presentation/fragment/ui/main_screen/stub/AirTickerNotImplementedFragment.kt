package com.example.feature_air_ticket_presentation.fragment.ui.main_screen.stub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.feature_air_ticket_presentation.R
import com.example.feature_air_ticket_presentation.databinding.FragmentAirTicketNotImplementedBinding
import ui.BaseFragment

class AirTickerNotImplementedFragment: BaseFragment() {

    private var _binding: FragmentAirTicketNotImplementedBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ConstraintLayout? {

        _binding = FragmentAirTicketNotImplementedBinding.inflate(inflater, container, false)
        val root = binding?.root

        val textView = binding?.tvNotImplemented
        textView?.text = getString(R.string.not_implemented_yet)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
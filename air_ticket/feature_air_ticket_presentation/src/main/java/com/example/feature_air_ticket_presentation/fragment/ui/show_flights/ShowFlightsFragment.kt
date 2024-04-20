package com.example.feature_air_ticket_presentation.fragment.ui.show_flights

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.feature_air_ticket_presentation.R
import com.example.feature_air_ticket_presentation.databinding.FragmentShowFlightsBinding
import ui.BaseFragment
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ShowFlightsFragment: BaseFragment() {

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

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setDateInChip() {
        val date = Date()
        val dateFormat = SimpleDateFormat("dd MMM, E", Locale("ru", "RU"))
        val dateText = dateFormat.format(date).replace(".", "")
        val editableText = Editable.Factory.getInstance().newEditable(dateText)
        binding?.chipDate?.text = editableText
    }
}
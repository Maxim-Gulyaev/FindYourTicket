package com.example.findyourticket.ui.not_implemented

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.findyourticket.R
import com.example.findyourticket.databinding.FragmentNotImplementedBinding

class NotImplementedFragment : Fragment() {

    private var _binding: FragmentNotImplementedBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ConstraintLayout? {
        _binding = FragmentNotImplementedBinding.inflate(inflater, container, false)

        binding?.apply {
            tvNotImplemented.text = getString(R.string.not_implemented_yet)
        }

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
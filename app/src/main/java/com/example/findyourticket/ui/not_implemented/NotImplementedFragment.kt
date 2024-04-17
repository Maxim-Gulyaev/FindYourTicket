package com.example.findyourticket.ui.not_implemented

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.findyourticket.R
import com.example.findyourticket.databinding.FragmentNotImplementedBinding

class NotImplementedFragment : Fragment() {

    private var _binding: FragmentNotImplementedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNotImplementedBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView = binding.textDashboard
        textView.text = getString(R.string.not_implemented_yet)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
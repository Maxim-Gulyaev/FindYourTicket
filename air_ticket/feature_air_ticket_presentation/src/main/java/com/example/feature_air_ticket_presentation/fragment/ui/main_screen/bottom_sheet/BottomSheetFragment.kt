package com.example.feature_air_ticket_presentation.fragment.ui.main_screen.bottom_sheet

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import com.example.feature_air_ticket_presentation.R
import com.example.feature_air_ticket_presentation.databinding.FragmentBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment: BottomSheetDialogFragment() {

    private var _binding: FragmentBottomSheetBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ConstraintLayout? {
        _binding = FragmentBottomSheetBinding.inflate(inflater, container, false)

        setClickListeners()

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setClickListeners() {
        binding?.apply {
            ivClear.setOnClickListener {
                etWhere.text.clear()
            }
            vRouteListener.setOnClickListener {
                navigateToStub()
            }
            vSomewhereListener.setOnClickListener {
                etWhere.setText(R.string.somewhere)
            }
            vWeekendListener.setOnClickListener {
                navigateToStub()
            }
            vHotListener.setOnClickListener {
                navigateToStub()
            }
            vFirstTownListener.setOnClickListener {
                setDestinationText(tvFirstTown.text)
            }
            vSecondTownListener.setOnClickListener {
                setDestinationText(tvSecondTown.text)
            }
            vThirdTownListener.setOnClickListener {
                setDestinationText(tvThirdTown.text)
            }
        }
    }

    private fun navigateToStub() {
        findNavController().apply {
            setGraph(R.navigation.nav_graph_air_ticket)
            navigate(R.id.action_airTicketsMainFragment_to_airTicketNotImplementedFragment)
        }
    }

    private fun setDestinationText(text: CharSequence) {
        val destinationText = Editable.Factory.getInstance().newEditable(text)
        binding?.etWhere?.text = destinationText
    }

}
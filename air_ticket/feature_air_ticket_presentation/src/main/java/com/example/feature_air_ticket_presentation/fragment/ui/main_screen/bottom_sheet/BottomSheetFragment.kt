package com.example.feature_air_ticket_presentation.fragment.ui.main_screen.bottom_sheet

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.feature_air_ticket_presentation.R
import com.example.feature_air_ticket_presentation.databinding.FragmentBottomSheetBinding
import com.example.feature_air_ticket_presentation.fragment.utils.Constants.DEPARTURE_DESTINATION_TEXT_KEY
import com.example.feature_air_ticket_presentation.fragment.utils.Constants.DEPARTURE_DESTINATION_TEXT_RESULT
import com.example.feature_air_ticket_presentation.fragment.utils.Constants.DEPARTURE_TEXT_KEY
import com.example.feature_air_ticket_presentation.fragment.utils.Constants.DEPARTURE_TEXT_RESULT
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentBottomSheetBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ConstraintLayout? {
        _binding = FragmentBottomSheetBinding.inflate(inflater, container, false)

        setClickListeners()
        setDepartureText()

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setClickListeners() {
        binding?.apply {
            etWhere.setOnEditorActionListener { v, actionId, event ->
                setFragmentResult()
                navigateToFragment(
                    R.id.action_airTicketsMainFragment_to_showFlightsFragment
                )
                true
            }
            ivClear.setOnClickListener {
                etWhere.text.clear()
            }
            vRouteListener.setOnClickListener {
                navigateToFragment(
                    R.id.action_airTicketsMainFragment_to_airTicketNotImplementedFragment
                )
            }
            vSomewhereListener.setOnClickListener {
                etWhere.setText(R.string.somewhere)
            }
            vWeekendListener.setOnClickListener {
                navigateToFragment(
                    R.id.action_airTicketsMainFragment_to_airTicketNotImplementedFragment
                )
            }
            vHotListener.setOnClickListener {
                navigateToFragment(
                    R.id.action_airTicketsMainFragment_to_airTicketNotImplementedFragment
                )
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

    private fun navigateToFragment(destination: Int) {
        findNavController().apply {
            navigate(destination)
        }
    }

    private fun setDestinationText(text: CharSequence) {
        val destinationText = Editable.Factory.getInstance().newEditable(text)
        binding?.etWhere?.text = destinationText
    }

    private fun setDepartureText() {
        requireActivity().supportFragmentManager.setFragmentResultListener(
            DEPARTURE_TEXT_RESULT,
            viewLifecycleOwner
        ) { _, bundle ->
            binding?.tvFrom?.text = bundle.getCharSequence(DEPARTURE_TEXT_KEY)
        }
    }

    private fun setFragmentResult() {
        binding?.apply {
            val destinationDepartureText = Pair(
                tvFrom.text.toString(),
                etWhere.text.toString()
            )
            requireActivity().supportFragmentManager.setFragmentResult(
                DEPARTURE_DESTINATION_TEXT_RESULT,
                bundleOf(
                    Pair(
                        DEPARTURE_DESTINATION_TEXT_KEY,
                        destinationDepartureText
                    )
                )
            )
        }
    }

}
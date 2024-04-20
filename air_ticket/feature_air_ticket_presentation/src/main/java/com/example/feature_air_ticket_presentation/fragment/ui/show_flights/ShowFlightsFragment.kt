package com.example.feature_air_ticket_presentation.fragment.ui.show_flights

import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProviders
import com.example.feature_air_ticket_data.data_source.MainScreenDataSourceImpl
import com.example.feature_air_ticket_data.repository.MainScreenRepositoryImpl
import com.example.feature_air_ticket_domain.use_case.get_music_offer_list.GetDirectFlightListUseCaseImpl
import com.example.feature_air_ticket_presentation.databinding.FragmentShowFlightsBinding
import com.example.feature_air_ticket_presentation.fragment.utils.ShowFlightsViewModelFactory
import ui.BaseFragment
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ShowFlightsFragment : BaseFragment() {

    //TODO rid this horrible code using Dagger
    private val viewModel by lazy {
        ViewModelProviders.of(
            this, ShowFlightsViewModelFactory(
                GetDirectFlightListUseCaseImpl(
                    MainScreenRepositoryImpl(
                        MainScreenDataSourceImpl()
                    )
                )
            )
        ).get(ShowFlightsViewModel::class.java)
    }

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
        getDirectFlightList()

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

    private fun getDirectFlightList() {
        viewModel.getDirectFlightList()
        viewModel.directFlightList.observe(viewLifecycleOwner) { list ->
            Log.i("maxlog", list.toString())
        }
    }
}
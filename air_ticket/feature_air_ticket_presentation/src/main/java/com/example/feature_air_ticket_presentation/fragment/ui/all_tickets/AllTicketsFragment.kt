package com.example.feature_air_ticket_presentation.fragment.ui.all_tickets

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProviders
import com.example.feature_air_ticket_data.data_source.MainScreenDataSourceImpl
import com.example.feature_air_ticket_data.repository.MainScreenRepositoryImpl
import com.example.feature_air_ticket_domain.use_case.get_ticket_list.GetTicketListUseCaseImpl
import com.example.feature_air_ticket_presentation.databinding.FragmentAllTicketsBinding
import com.example.feature_air_ticket_presentation.fragment.utils.view_model_factory.AllTicketsViewModelFactory
import ui.BaseFragment

class AllTicketsFragment: BaseFragment() {

    //TODO rid this horrible code using Dagger
    private val viewModel by lazy {
        ViewModelProviders.of(
            this, AllTicketsViewModelFactory(
                GetTicketListUseCaseImpl(
                    MainScreenRepositoryImpl(
                        MainScreenDataSourceImpl()
                    )
                )
            )
        ).get(AllTicketsViewModel::class.java)
    }

    private var _binding: FragmentAllTicketsBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ConstraintLayout? {
        _binding = FragmentAllTicketsBinding.inflate(inflater, container, false)

        setTicketRecyclerView()

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setTicketRecyclerView() {
        viewModel.getTicketList()
        viewModel.ticketList.observe(viewLifecycleOwner) { list ->
            Log.i("maxlog", list.toString())
        }
    }

}
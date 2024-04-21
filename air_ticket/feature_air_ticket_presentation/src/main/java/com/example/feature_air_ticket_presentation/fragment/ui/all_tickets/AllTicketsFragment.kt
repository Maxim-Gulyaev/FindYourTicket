package com.example.feature_air_ticket_presentation.fragment.ui.all_tickets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.feature_air_ticket_presentation.databinding.FragmentAllTicketsBinding
import com.example.feature_air_ticket_presentation.fragment.ui.all_tickets.adapter.AllTicketsAdapter
import ui.BaseFragment
import javax.inject.Inject

class AllTicketsFragment : BaseFragment() {

    @Inject
    lateinit var viewModel: AllTicketsViewModel
    private var _binding: FragmentAllTicketsBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.application as App).appComponent.inject(this)
    }

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
            binding?.rvTicket?.apply {
                layoutManager = LinearLayoutManager(
                    requireActivity(),
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                adapter = AllTicketsAdapter(list)
            }
        }
    }

}
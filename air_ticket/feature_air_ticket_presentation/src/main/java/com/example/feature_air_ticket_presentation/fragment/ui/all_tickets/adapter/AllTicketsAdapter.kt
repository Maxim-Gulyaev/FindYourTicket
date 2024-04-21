package com.example.feature_air_ticket_presentation.fragment.ui.all_tickets.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.feature_air_ticket_presentation.databinding.RecyclerMusicTripItemBinding
import com.example.feature_air_ticket_presentation.databinding.RecyclerTicketItemBinding
import com.example.feature_air_ticket_presentation.fragment.ui.all_tickets.model.FlightInfo
import com.example.feature_air_ticket_presentation.fragment.ui.all_tickets.model.HandLuggage
import com.example.feature_air_ticket_presentation.fragment.ui.all_tickets.model.Luggage
import com.example.feature_air_ticket_presentation.fragment.ui.all_tickets.model.Ticket
import com.example.feature_air_ticket_presentation.fragment.ui.main_screen.adapter.MusicOfferAdapter
import com.example.feature_air_ticket_presentation.fragment.ui.main_screen.model.Price

class AllTicketsAdapter(
    private val ticketList: List<Ticket>
): RecyclerView.Adapter<AllTicketsAdapter.AllTicketsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllTicketsViewHolder {
        val itemBinding = RecyclerTicketItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return AllTicketsViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = ticketList.size

    override fun onBindViewHolder(holder: AllTicketsViewHolder, position: Int) {
        val item = ticketList[position]

        holder.apply {
            price.text = item.price.value.toString()
        }
    }

    class AllTicketsViewHolder(
        binding: RecyclerTicketItemBinding
    ): ViewHolder(binding.root) {
        val badge = binding.tvBadge
        val price = binding.tvPrice
        val departureTime = binding.tvDepartureTime
        val arrivalTime = binding.tvArrivalTime
        val transfer = binding.tvTransfer
        val travelTime = binding.tvTravelTime
        val departureAirport = binding.tvDepartureAirport
        val arrivalAirport = binding.tvArrivalAirport
    }
}
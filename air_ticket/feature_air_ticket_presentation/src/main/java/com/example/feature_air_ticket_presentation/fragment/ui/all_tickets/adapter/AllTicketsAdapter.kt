package com.example.feature_air_ticket_presentation.fragment.ui.all_tickets.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.feature_air_ticket_presentation.R
import com.example.feature_air_ticket_presentation.databinding.RecyclerTicketItemBinding
import com.example.feature_air_ticket_presentation.fragment.ui.all_tickets.model.Ticket
import com.example.feature_air_ticket_presentation.fragment.utils.calculateTravelTime
import com.example.feature_air_ticket_presentation.fragment.utils.formatPrice
import com.example.feature_air_ticket_presentation.fragment.utils.formatTime

class AllTicketsAdapter(
    private val ticketList: List<Ticket>
) : RecyclerView.Adapter<AllTicketsAdapter.AllTicketsViewHolder>() {

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
        val context = holder.price.context

        holder.apply {
            price.text = context.getString(
                R.string.price,
                item.price.value.formatPrice()
            )
            departureTime.text = item.departure.date.formatTime()
            arrivalTime.text = item.arrival.date.formatTime()
            departureAirport.text = item.departure.airport
            arrivalAirport.text = item.arrival.airport
            travelTime.text =
                calculateTravelTime(
                    item.departure.date,
                    item.arrival.date
                )
            if (item.hasTransfer) {
                transfer.visibility = View.INVISIBLE
            }
            if (!item.badge.isNullOrEmpty()) {
                badge.isVisible = true
                badgeText.text = item.badge
            }
        }
    }

    class AllTicketsViewHolder(
        binding: RecyclerTicketItemBinding
    ) : ViewHolder(binding.root) {
        val badge = binding.cvBadge
        val badgeText = binding.tvBadge
        val price = binding.tvPrice
        val departureTime = binding.tvDepartureTime
        val arrivalTime = binding.tvArrivalTime
        val transfer = binding.tvTransfer
        val travelTime = binding.tvTravelTime
        val departureAirport = binding.tvDepartureAirport
        val arrivalAirport = binding.tvArrivalAirport
    }
}
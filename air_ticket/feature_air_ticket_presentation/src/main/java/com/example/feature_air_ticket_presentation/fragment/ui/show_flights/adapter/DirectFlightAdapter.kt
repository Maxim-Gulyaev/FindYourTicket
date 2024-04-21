package com.example.feature_air_ticket_presentation.fragment.ui.show_flights.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.feature_air_ticket_presentation.databinding.RecyclerDirectFlightItemBinding
import com.example.feature_air_ticket_presentation.fragment.ui.show_flights.model.DirectFlight
import com.example.feature_air_ticket_presentation.fragment.utils.Constants.ITEM_COUNT
import com.example.feature_air_ticket_presentation.fragment.utils.Constants.SPACE

class DirectFlightAdapter(
    private val flightList: List<DirectFlight>
): RecyclerView.Adapter<DirectFlightAdapter.DirectFlightViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DirectFlightViewHolder {
        val itemBinding = RecyclerDirectFlightItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DirectFlightViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = ITEM_COUNT

    override fun onBindViewHolder(holder: DirectFlightViewHolder, position: Int) {
        val item = flightList[position]

        holder.apply {
            title.text = item.title
            time.text = item.timeRange.joinToString(SPACE)
            price.text = item.price.value.toString()
            when (position) {
                0 -> icon.setCardBackgroundColor(Color.RED)
                1 -> icon.setCardBackgroundColor(Color.BLUE)
                2 -> icon.setCardBackgroundColor(Color.WHITE)
            }
        }
    }

    class DirectFlightViewHolder(
        binding: RecyclerDirectFlightItemBinding
    ): ViewHolder(binding.root) {
        val title = binding.tvTitle
        val time = binding.tvTime
        val price = binding.tvPrice
        val icon = binding.cvRoundIcon
    }
}
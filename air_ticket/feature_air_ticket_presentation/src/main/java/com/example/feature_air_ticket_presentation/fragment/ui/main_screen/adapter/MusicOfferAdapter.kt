package com.example.feature_air_ticket_presentation.fragment.ui.main_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.feature_air_ticket_presentation.R
import com.example.feature_air_ticket_presentation.databinding.RecyclerMusicTripItemBinding
import com.example.feature_air_ticket_presentation.fragment.ui.main_screen.model.MusicOffer
import com.example.feature_air_ticket_presentation.fragment.utils.formatPrice

class MusicOfferAdapter(
    private val offerList: List<MusicOffer>
) : RecyclerView.Adapter<MusicOfferAdapter.MusicOfferViewHolder>() {

    // TODO: вынести настройку интерфейса в метод onBind()
    // TODO:переписать на единый адаптер для всех фрагментов модуля

    override fun onBindViewHolder(holder: MusicOfferViewHolder, position: Int) {
        val item = offerList[position]

        holder.apply {
            title.text = item.title
            town.text = item.town
            price.text = item.price.value.formatPrice()
            when (item.musicOfferId) {
                1 -> image.setImageResource(R.drawable.antwoord)
                2 -> image.setImageResource(R.drawable.socrat)
                3 -> image.setImageResource(R.drawable.lambapict)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MusicOfferViewHolder {
        val itemBinding = RecyclerMusicTripItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MusicOfferViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = offerList.size

    class MusicOfferViewHolder(
        binding: RecyclerMusicTripItemBinding
    ) : ViewHolder(binding.root) {
        val image = binding.ivMusicianPicture
        val title = binding.tvMusicianName
        val town = binding.tvMusicianCity
        val price = binding.tvPrice
    }

}
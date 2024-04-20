package com.example.feature_air_ticket_presentation.fragment.ui.main_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.feature_air_ticket_domain.use_case.get_music_offer_list.GetMusicOfferListUseCase
import com.example.feature_air_ticket_presentation.fragment.ui.main_screen.model.MusicOffer
import com.example.feature_air_ticket_presentation.fragment.utils.toMusicOffer
import kotlinx.coroutines.launch
import ui.BaseViewModel

class AirTicketsMainViewModel(
    private val getMusicOfferListUseCase: GetMusicOfferListUseCase
): BaseViewModel() {

    private val _musicOfferList = MutableLiveData<List<MusicOffer>>()
    val musicOfferList: LiveData<List<MusicOffer>> = _musicOfferList

    fun getMusicOffersList() {
        val offers = mutableListOf<MusicOffer>()
        viewModelScope.launch {
            getMusicOfferListUseCase.execute().collect() { value ->
                offers.add(value.toMusicOffer())
            }
            _musicOfferList.value = offers
        }
    }

}
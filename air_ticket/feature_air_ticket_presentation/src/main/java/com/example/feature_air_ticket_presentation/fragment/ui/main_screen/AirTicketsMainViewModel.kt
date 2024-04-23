package com.example.feature_air_ticket_presentation.fragment.ui.main_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.feature_air_ticket_domain.use_case.get_music_offer_list.GetMusicOfferListUseCase
import com.example.feature_air_ticket_presentation.fragment.ui.main_screen.model.MusicOffer
import com.example.feature_air_ticket_presentation.fragment.utils.toMusicOffer
import kotlinx.coroutines.launch
import ui.BaseViewModel
import javax.inject.Inject

class AirTicketsMainViewModel @Inject constructor(
    private val getMusicOfferListUseCase: GetMusicOfferListUseCase
): BaseViewModel() {

    private val _musicOfferLiveData = MutableLiveData<List<MusicOffer>>()
    val musicOfferLiveData: LiveData<List<MusicOffer>> = _musicOfferLiveData

    fun getMusicOffersList() {
        val offers = mutableListOf<MusicOffer>()
        viewModelScope.launch {
            getMusicOfferListUseCase.execute().collect() { value ->
                offers.add(value.toMusicOffer())
            }
            _musicOfferLiveData.value = offers
        }
    }

}
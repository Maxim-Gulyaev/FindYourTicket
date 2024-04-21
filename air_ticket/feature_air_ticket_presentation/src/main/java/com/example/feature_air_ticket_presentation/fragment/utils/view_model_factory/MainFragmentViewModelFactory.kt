package com.example.feature_air_ticket_presentation.fragment.utils.view_model_factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.feature_air_ticket_domain.use_case.get_music_offer_list.GetMusicOfferListUseCase
import com.example.feature_air_ticket_presentation.fragment.ui.main_screen.AirTicketsMainViewModel

class MainFragmentViewModelFactory(
    private val getMusicOfferListUseCase: GetMusicOfferListUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AirTicketsMainViewModel(getMusicOfferListUseCase) as T
    }

}
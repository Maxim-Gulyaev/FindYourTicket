package com.example.feature_air_ticket_presentation.fragment.ui.main_screen.bottom_sheet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ui.BaseViewModel

class BottomSheetViewModel: BaseViewModel() {

    private val _departureLiveData = MutableLiveData<String>()
    val departureLiveData: LiveData<String> = _departureLiveData

    fun setDepartureText(departureText: String) {
        _departureLiveData.value = departureText
    }

}
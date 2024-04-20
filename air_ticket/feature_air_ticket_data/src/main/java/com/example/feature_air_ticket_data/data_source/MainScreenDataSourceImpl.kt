package com.example.feature_air_ticket_data.data_source

import com.example.feature_air_ticket_data.model.DirectFlightModel
import com.example.feature_air_ticket_data.model.MusicOfferModel
import com.example.feature_air_ticket_data.utils.DirectFlightJsonData
import com.example.feature_air_ticket_data.utils.MusicOfferJsonData
import com.google.gson.Gson
import com.google.gson.JsonObject

private const val MUSIC_ARRAY_NAME = "offers"
private const val DIRECT_FLIGHT_ARRAY_NAME = "tickets_offers"

class MainScreenDataSourceImpl(): MainScreenDataSource {

    override fun getMusicOfferList(): List<MusicOfferModel> =
        getListFromJson(
            MusicOfferJsonData.mockJsonString,
            MusicOfferModel::class.java,
            MUSIC_ARRAY_NAME
        )

    override fun getDirectFlightList(): List<DirectFlightModel> =
        getListFromJson(
            DirectFlightJsonData.mockJsonString,
            DirectFlightModel::class.java,
            DIRECT_FLIGHT_ARRAY_NAME
        )

    private fun <T> getListFromJson(
        jsonData: String,
        clazz: Class<T>,
        arrayName: String
    ): List<T> {
        val gson = Gson()
        val jsonObject = gson.fromJson(jsonData, JsonObject::class.java)
        val offersJsonArray = jsonObject.getAsJsonArray(arrayName)

        val resultList = mutableListOf<T>()
        offersJsonArray.forEach { offerElement ->
            val offerObject = gson.fromJson(offerElement, clazz)
            resultList.add(offerObject)
        }
        return resultList
    }



}
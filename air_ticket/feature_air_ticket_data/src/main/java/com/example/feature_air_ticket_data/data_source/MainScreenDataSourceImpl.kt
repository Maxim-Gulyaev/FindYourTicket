package com.example.feature_air_ticket_data.data_source

import com.example.feature_air_ticket_data.model.MusicOfferModel
import com.example.feature_air_ticket_data.utils.MusicOfferJsonData
import com.google.gson.Gson
import com.google.gson.JsonObject

class MainScreenDataSourceImpl(): MainScreenDataSource {

    override fun getMusicOfferList(): List<MusicOfferModel> {
        /*val jsonData = MusicOfferJsonData.jsonObject
        val gson = Gson()
        val type = object : TypeToken<MusicOfferJsonData>() {}.type
        val musicOfferJsonData = gson.fromJson<MusicOfferJsonData>(jsonData.toString(), type)
        return musicOfferJsonData.*/

        /*val jsonData = MusicOfferJsonData.mockJsonString
        val musicOfferModel = Json.decodeFromString<MusicOfferModel>(jsonData)
        return musicOfferModel*/

        val jsonData = MusicOfferJsonData.mockJsonString
        val gson = Gson()
        val jsonObject = gson.fromJson(jsonData, JsonObject::class.java)
        val offersJsonArray = jsonObject.getAsJsonArray("offers")

        val offersList = mutableListOf<MusicOfferModel>()
        offersJsonArray.forEach { offerElement ->
            val offerObject = gson.fromJson(offerElement, MusicOfferModel::class.java)
            offersList.add(offerObject)
        }
        return offersList
    }

}
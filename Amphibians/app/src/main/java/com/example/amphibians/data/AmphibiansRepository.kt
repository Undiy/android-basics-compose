package com.example.amphibians.data

import com.example.amphibians.model.Amphibian
import com.example.amphibians.network.AmphibiansApiService

interface AmphibiansRepository {
    suspend fun getAmphibians(): List<Amphibian>
}

//object NetworkMarsPhotosRepository(
//    private val amphibiansApiService =
//) : AmphibiansRepository {
//    /** Fetches list of MarsPhoto from marsApi*/
//    override suspend fun getAmphibians(): List<Amphibian> = amphibiansApiService.getAmphibians()
//}
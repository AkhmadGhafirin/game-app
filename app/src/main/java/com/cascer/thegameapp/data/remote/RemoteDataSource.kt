package com.cascer.thegameapp.data.remote

import android.util.Log
import com.cascer.thegameapp.data.remote.network.ApiResponse
import com.cascer.thegameapp.data.remote.network.ApiService
import com.cascer.thegameapp.data.remote.response.GameResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getAllMovie(): Flow<ApiResponse<List<GameResponse>>> {
        return flow {
            try {
                val response = apiService.getListGame(
                    key = BuildConfig.API_KEY,
                    page = 1,
                    pageSize = 10
                )
                val dataArray = response.results
                if (dataArray?.isNotEmpty() == true) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}
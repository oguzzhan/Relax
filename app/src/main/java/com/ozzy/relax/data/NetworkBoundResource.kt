package com.ozzy.relax.data

import androidx.annotation.MainThread
import com.ozzy.relax.data.model.Resource
import kotlinx.coroutines.flow.flow
import retrofit2.Response

/**
 * Created by Oğuzhan Karacan on 4.09.2021.
 */
abstract class NetworkBoundResource<ResultType> {

    fun asFlow() = flow {
        emit(Resource.Loading(null))

        val response = fetchFromNetwork()
        if (response.isSuccessful) {
            emit(Resource.Success(response))
        } else {
            emit(Resource.Error("Hata"))
        }
    }

    @MainThread
    protected abstract suspend fun fetchFromNetwork(): Response<ResultType>
}

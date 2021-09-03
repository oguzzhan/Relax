package com.ozzy.relax.ui.main

import com.ozzy.relax.data.NetworkBoundResource
import com.ozzy.relax.data.RelaxService
import com.ozzy.relax.data.model.DashboardResponse
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Oğuzhan Karacan on 4.09.2021.
 */
class DashboardRepository @Inject constructor(
    private val relaxService: RelaxService
) {
    fun getDashboard() =
        object : NetworkBoundResource<DashboardResponse>() {
            override suspend fun fetchFromNetwork(): Response<DashboardResponse> {
                return relaxService.getData()
            }
        }.asFlow()
}
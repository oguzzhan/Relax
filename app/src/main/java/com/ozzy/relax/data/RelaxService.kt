package com.ozzy.relax.data

import com.ozzy.relax.data.model.DashboardResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Oğuzhan Karacan on 4.09.2021.
 */
interface RelaxService {
    @GET("files/MobileInterviewProjectData.json")
    suspend fun getData(): Response<DashboardResponse>
}
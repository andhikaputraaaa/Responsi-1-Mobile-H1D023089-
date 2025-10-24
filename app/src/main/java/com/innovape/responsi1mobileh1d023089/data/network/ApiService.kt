package com.innovape.responsi1mobileh1d023089.data.network

import com.innovape.responsi1mobileh1d023089.data.model.TeamResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiService {
    @Headers("X-Auth-Token: 74c9b546c1904f2f85c15ee751504250")
    @GET("teams/{id}")
    fun getTeamById(@Path("id") teamId: Int): Call<TeamResponse>
}
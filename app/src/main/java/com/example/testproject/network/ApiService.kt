package com.example.testproject.network

import com.example.testproject.ApiDataClasses.DataClass
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("primeapi/admin_api/get_adminHome.php")
    suspend fun getAdminHome(
        @Field("distributor_user_id") distributorUserId: String,
        @Field("distributor_id") distributorId: String
    ): Response<DataClass>
}

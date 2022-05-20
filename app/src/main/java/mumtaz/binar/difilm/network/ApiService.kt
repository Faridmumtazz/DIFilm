package mumtaz.binar.difilm.network

import mumtaz.binar.difilm.model.GetAllNewsResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("news")
    fun getAllNews() : Call<List<GetAllNewsResponseItem>>
}
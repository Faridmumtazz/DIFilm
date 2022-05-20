package mumtaz.binar.difilm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mumtaz.binar.difilm.model.GetAllNewsResponseItem
import mumtaz.binar.difilm.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelNews : ViewModel(){

    lateinit var liveDataNews : MutableLiveData<List<GetAllNewsResponseItem>>

    init {
        liveDataNews = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<List<GetAllNewsResponseItem>> {
        return liveDataNews
    }

    fun getApiNews(){
        ApiClient.instance.getAllNews()
            .enqueue(object : Callback<List<GetAllNewsResponseItem>> {
                override fun onResponse(
                    call: Call<List<GetAllNewsResponseItem>>,
                    response: Response<List<GetAllNewsResponseItem>>
                ) {
                    if (response.isSuccessful) {
                        liveDataNews.postValue(response.body())
                    }else{
                        liveDataNews.postValue(null)
                    }

                }

                override fun onFailure(call: Call<List<GetAllNewsResponseItem>>, t: Throwable) {
                    liveDataNews.postValue(null)
                }

            })
    }
}
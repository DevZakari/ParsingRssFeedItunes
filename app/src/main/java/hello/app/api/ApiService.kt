package hello.app.api

import hello.app.model.Feed
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("WebObjects/MZStoreServices.woa/ws/RSS/topsongs/limit=10/xml")
    fun getTopSongs(): Call<Feed>
}

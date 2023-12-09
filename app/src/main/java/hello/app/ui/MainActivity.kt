package hello.app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import android.util.Log
import hello.app.R
import hello.app.api.ApiClient
import hello.app.model.Entry
import hello.app.model.Feed
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var topSongsAdapter: TopSongsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        topSongsAdapter = TopSongsAdapter()
        recyclerView.adapter = topSongsAdapter

        Log.d("ziko","hello hello")

        //fakeData()

        // Fetch data from API
        val apiService = ApiClient.apiService
        val call = apiService.getTopSongs()

        call.enqueue(object : Callback<Feed> {
            override fun onResponse(call: Call<Feed>, response: Response<Feed>) {
                if (response.isSuccessful) {
                    val feed = response.body()
                    val entries = feed?.entry
                    // Log response data to console
                    Log.d("MainActivity", "Response: $feed")
                    // Update RecyclerView with data
                    topSongsAdapter.setData(entries)
                } else {
                    Log.e("MainActivity", "Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<Feed>, t: Throwable) {
                Log.e("MainActivity", "Failure: ${t.message}")
            }
        })
    }




}

package com.wf.nbalivestats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.i
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    val logging = HttpLoggingInterceptor()
    val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://www.balldontlie.io/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(NbaStatsBallDontLie::class.java)
    val call = service.getAllTeams(0, 30)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        call.enqueue(object : Callback<NbaTeams> {
            override fun onResponse(call: Call<NbaTeams>, response: Response<NbaTeams>) {
                if (response.code() == 200) {
                    response.body()?.data?.forEach {
                        i("TEST", "Team: ${it.fullName}")
                    }
                }
            }

            override fun onFailure(call: Call<NbaTeams>, t: Throwable) {
                i("test", "failure")
            }
        }
        )
    }
}


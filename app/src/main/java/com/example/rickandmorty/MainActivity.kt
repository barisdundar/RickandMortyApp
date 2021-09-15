package com.example.rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val provider = RickAndMortyServiceProvider()

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)


        provider.rickAndMortyService.getAllCharacters().enqueue(object :
                Callback<CharactherResponse> {
            override fun onResponse(
                    call: Call<CharactherResponse>,
                    response: Response<CharactherResponse>
            ) {
                if (response.body() != null) {
                    val adapter = RmCharacterAdapter(
                            response.body()!!.results
                    )
                    recyclerView.adapter = adapter
                }
            }

            override fun onFailure(call: Call<CharactherResponse>, t: Throwable) {
                Log.d("FAIL:::", "failure")
            }
        })


    }
}
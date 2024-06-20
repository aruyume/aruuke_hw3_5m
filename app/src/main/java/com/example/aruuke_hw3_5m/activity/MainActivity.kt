package com.example.aruuke_hw3_5m.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aruuke_hw3_5m.R
import com.example.aruuke_hw3_5m.RickAdapter
import com.example.aruuke_hw3_5m.models.RickMorty
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: RickAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        adapter = RickAdapter()
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.adapter = adapter

        RetrofitService.api.fetchCharacters().enqueue(object : Callback<RickMorty> {
            override fun onResponse(call: Call<RickMorty>, response: Response<RickMorty>) {
                val characters = response.body()?.results
                if (!characters.isNullOrEmpty()) {
                    adapter.setData(characters)
                }
            }

            override fun onFailure(call: Call<RickMorty>, t: Throwable) {
                Log.d("TAG", t.message.toString())
            }
        })
    }
}

package com.example.dogs.activities

import android.content.Intent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dogs.R
import com.example.dogs.adapters.DogAdapter
import com.example.dogs.models.Dog

class MainActivity : AppCompatActivity() {

    private lateinit var breedRecyclerView: RecyclerView
    private lateinit var breedAdapter: DogAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        //var TUBAR = findViewById<Toolbar>(R.id.toolbar)

        //setSupportActionBar(toolbar)

        breedRecyclerView = findViewById(R.id.recycler_breeds)

        breedRecyclerView.layoutManager = LinearLayoutManager( this)

        setAdapter(getData1())
    }

    private fun getData1():MutableList<Dog>{
        var lst: MutableList<Dog> = mutableListOf(
            Dog("Affenpinscher","https://images.dog.ceo/breeds/affenpinscher/n02110627_12431.jpg"),
            Dog("Redbone","https://images.dog.ceo/breeds/redbone/n02090379_1006.jpg"),
            Dog("Pug","https://images.dog.ceo/breeds/pug/n02110958_3644.jpg"),
            Dog("Affenpinscher","https://images.dog.ceo/breeds/affenpinscher/n02110627_12431.jpg"),
            Dog("Redbone","https://images.dog.ceo/breeds/redbone/n02090379_1006.jpg"),
            Dog("Pug","https://images.dog.ceo/breeds/pug/n02110958_3644.jpg"),
            )
        return lst
    }

    private fun setAdapter(lst:MutableList<Dog>){
        breedAdapter = DogAdapter(lst){ dog ->
            val intent = Intent(this,DogActivity::class.java)
            intent.putExtra("dog",dog)
            startActivity(intent)

        }
        breedRecyclerView.adapter = breedAdapter
    }


}
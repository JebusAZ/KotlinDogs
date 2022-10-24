package com.example.dogs.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import com.example.dogs.R
import com.example.dogs.models.Dog
import com.squareup.picasso.Picasso


class DogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog)

        val dog = intent.getSerializableExtra("dog") as? Dog

        var imageDog = findViewById<ImageView>(R.id.img_dog)


        //Picasso.get().load(dog?.imageUrl).into(imageDog)
        Picasso.get().load((dog?.imageurl)).into(imageDog)

        //var toolbar = findViewById<Toolbar>(R.id.toolbar)
        var toolbar = findViewById<Toolbar>(R.id.toolbar)

        //setSupportActionBar(toolbar)
        //setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}


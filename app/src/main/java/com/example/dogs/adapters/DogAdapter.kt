package com.example.dogs.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogs.R
import com.example.dogs.databinding.ItemDogBinding
import com.example.dogs.models.Dog
import com.squareup.picasso.Picasso

class DogAdapter (dogList: List<Dog>, private val listener:(Dog) -> Unit):
    RecyclerView.Adapter<DogAdapter.ViewHolder>(){

    private var dogList:List<Dog> = dogList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v:View = LayoutInflater.from(parent.context).inflate(R.layout.item_dog,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dog:Dog = dogList[position]

        //holder.textBreed.text = dog.name
        holder.binding.textBreed.text = dog.name

        holder.itemView.setOnClickListener{
            listener(dog)
        }

        //Picasso.get().load(dog.imageurl).into(holder.imageBreed)
        Picasso.get().load(dog.imageurl).into(holder.binding.imgBreed)
    }

    override fun getItemCount(): Int {
        return dogList.size
    }

    class ViewHolder (v:View):RecyclerView.ViewHolder(v){
        //val textBreed: TextView = v.findViewById(R.id.text_breed)
        //val imageBreed: ImageView = v.findViewById(R.id.img_breed)
        val binding = ItemDogBinding.bind(v)
    }
}
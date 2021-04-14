package com.example.ejemploservicios

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ejemploservicios.databinding.ItemDogBinding
import com.squareup.picasso.Picasso
//cargar la imagen cada que quiero accerder a un objeto de la lista
class DogViewHolder(view: View): RecyclerView.ViewHolder (view) {
    private  val  binding= ItemDogBinding.bind(view)
    fun bind(image:String){
        Picasso.get().load(image).into(binding.ivDog)
    }
}
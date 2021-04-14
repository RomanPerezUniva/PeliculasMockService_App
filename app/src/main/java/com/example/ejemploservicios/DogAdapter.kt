package com.example.ejemploservicios
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class DogAdapter (val images:List<String>):RecyclerView.Adapter<DogViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val layotInflater:LayoutInflater= LayoutInflater.from(parent.context)
        //cada que ebtras a un elemento de la lista..... continua
        //hacer el binding..... de los mentodos
        return  DogViewHolder(layotInflater.inflate(R.layout.item_dog,parent,false))

    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
     //Configurar el item por cada elemento de la lista del arreglo
        val item:String = images[position]
        holder.bind(item)

    }

    override fun getItemCount(): Int {
        //Cuantos elemento trae
        return images.size
    }

}
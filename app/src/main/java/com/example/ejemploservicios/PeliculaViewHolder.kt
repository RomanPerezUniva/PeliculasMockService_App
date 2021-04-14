package com.example.ejemploservicios
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ejemploservicios.databinding.ItemPeliculaBinding
import com.squareup.picasso.Picasso
class PeliculaViewHolder (view: View): RecyclerView.ViewHolder (view){
    private  val  binding= ItemPeliculaBinding.bind(view)
    fun bind(pelicula:Pelicula){
        binding.nombretv.text = pelicula.nombre?: "Titulo no encontrado"
        binding.directortv.text = pelicula.director?: "Director no encontrado"
        binding.generotv.text=pelicula.genero?: "Genero no encontrado"
        Picasso.get().load(pelicula.poster).into(binding.posteriv)
    }
}
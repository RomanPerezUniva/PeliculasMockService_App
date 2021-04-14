package com.example.ejemploservicios
import com.google.gson.annotations.SerializedName
data class PeliculasResponse (
        @SerializedName("peliculas") var peliculas: List<Pelicula>
        )
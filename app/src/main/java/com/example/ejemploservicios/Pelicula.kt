package com.example.ejemploservicios

import com.google.gson.annotations.SerializedName

data class Pelicula (
        @SerializedName("id") var id:String,
        @SerializedName("nombre") var nombre:String,
        @SerializedName("director") var director:String,
        @SerializedName("genero") var genero:String,
        @SerializedName("poster") var poster:String,

        )
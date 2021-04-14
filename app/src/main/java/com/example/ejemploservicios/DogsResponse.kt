package com.example.ejemploservicios

import com.google.gson.annotations.SerializedName
//Almacenar la informacion
data class DogsResponse (
    @SerializedName("status") var status:String,
    @SerializedName("message") var images:List<String>

        )
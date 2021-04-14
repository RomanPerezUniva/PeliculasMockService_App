package com.example.ejemploservicios
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url
//definir los metodos que acepta el servicio
interface APIService {
    //decorador hilo secundario
    @GET
    suspend fun getPeliculas(@Url url:String):Response<PeliculasResponse>
}
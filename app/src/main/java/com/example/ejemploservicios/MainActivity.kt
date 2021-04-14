package com.example.ejemploservicios
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejemploservicios.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.launch
class MainActivity : AppCompatActivity(){
    private val servidor: String ="https://demo7154177.mockable.io/"
    private lateinit var binding : ActivityMainBinding
    private  lateinit var adapter: PeliculaAdaptador
    private val peliculas= mutableListOf<Pelicula>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getRetrofit()
        obtenerPeliculas()
        initRecyclerView()
    }
    private fun initRecyclerView(){
        adapter=PeliculaAdaptador(peliculas)
        binding.peliculasrv.layoutManager=LinearLayoutManager(this)
        binding.peliculasrv.adapter=adapter
    }
    private  fun getRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl(servidor)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
   private fun obtenerPeliculas(){
       val endpoint: String ="peliculas"
       CoroutineScope(Dispatchers.IO).launch {
           val call:Response<PeliculasResponse> = getRetrofit().create(APIService::class.java).getPeliculas(endpoint)
           val peli:PeliculasResponse? = call.body()
           runOnUiThread{
               if(call.isSuccessful){
                   val cartelera:List<Pelicula> = peli?.peliculas?: emptyList()
                   peliculas.clear()
                   peliculas.addAll(cartelera)
                   adapter.notifyDataSetChanged()

               }else{
                   //Error
                   showError()

               }

           }
       }
   }
   private fun showError(){
       Toast.makeText(this,"Ha ocurrido un error", Toast.LENGTH_SHORT).show()
   }
}
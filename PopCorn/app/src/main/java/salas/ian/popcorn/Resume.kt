package salas.ian.popcorn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Resume : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resume)

        var bundle=intent.extras

        var numero : TextView=findViewById(R.id.numAsiento)
        var peliculaResume : TextView=findViewById(R.id.peliculaResume)

        if(bundle!=null){
            numero.text= bundle.getInt("asiento").toString()
            peliculaResume.text= bundle.getString("titulo")
        }

        var continuar:Button=findViewById(R.id.continuar)
        continuar.setOnClickListener {

            val intento:Intent=Intent(this,CatalogActivity::class.java)
            intento.putExtra("asiento",bundle?.getInt("asiento"))
            intento.putExtra("pelicula",bundle?.getString("titulo"))
            this.startActivity(intento)
        }


    }



}
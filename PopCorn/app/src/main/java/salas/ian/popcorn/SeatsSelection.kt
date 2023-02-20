package salas.ian.popcorn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class SeatsSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seats_selection)

        val title:TextView = findViewById(R.id.titleSeats)
        var posMovie=-1

        val bundle = intent.extras

        if(bundle!=null){
            title.text = bundle.getString("name")
            posMovie = bundle.getInt("id")
        }

        val row1:RadioGroup = findViewById(R.id.row1)
        val row2:RadioGroup = findViewById(R.id.row2)
        val row3:RadioGroup = findViewById(R.id.row3)
        val row4:RadioGroup = findViewById(R.id.row4)
        var asiento:Int = -1

        row1.setOnCheckedChangeListener { group, checkedID ->
            if(checkedID > -1){
                row2.clearCheck()
                row3.clearCheck()
                row4.clearCheck()
                asiento=checkedID
                row1.check(checkedID)
            }
        }

        row2.setOnCheckedChangeListener { group, checkedID ->
            if(checkedID > -1){
                row1.clearCheck()
                row3.clearCheck()
                row4.clearCheck()
                asiento=checkedID
                row2.check(checkedID)
            }
        }

        row3.setOnCheckedChangeListener { group, checkedID ->
            if(checkedID > -1){
                row2.clearCheck()
                row1.clearCheck()
                row4.clearCheck()
                asiento=checkedID
                row3.check(checkedID)
            }
        }

        row4.setOnCheckedChangeListener { group, checkedID ->
            if(checkedID > -1){
                row2.clearCheck()
                row3.clearCheck()
                row1.clearCheck()
                asiento=checkedID
                row4.check(checkedID)
            }
        }

        var confirm: Button = findViewById(R.id.confirm)
        //Añadir logica para reservar el lugar seleccionado por el usuario
        //Hacer una nueva actividad donde se vea el resumen de la compra es decir que se agurege el nombre del cliente y se vea el asiento que se seleccionó

        confirm.setOnClickListener {
            if(asiento == -1){
                Toast.makeText(this,"¡Debes escoger un asiento antes de proceder!", Toast.LENGTH_LONG).show()
            }else{
                val intento:Intent=Intent(this,Resume::class.java)
                intento.putExtra("asiento",asiento)
                intento.putExtra("titulo",bundle?.getString("name"))
                this.startActivity(intento)
            }
        }
    }
}

package salas.ian.popcorn

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.get

class SeatsSelection : AppCompatActivity() {
    var peliculas = Global.peliculas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seats_selection)

        val title:TextView = findViewById(R.id.titleSeats)

        val row1:RadioGroup = findViewById(R.id.row1)
        val row2:RadioGroup = findViewById(R.id.row2)
        val row3:RadioGroup = findViewById(R.id.row3)
        val row4:RadioGroup = findViewById(R.id.row4)

        val bundle = intent.extras
        var pos=0
        if(bundle!=null){
            title.text = bundle.getString("name")
            pos=bundle.getInt("pos")
            Log.d("Posicion",pos.toString())
            Log.d("Turfals",(peliculas?.get(pos)?.seats!!).toString())
            for(clients in peliculas?.get(pos)?.seats!!){
                var asientoCliente = clients.asiento-1
                if (asientoCliente<6){
                    row1[asientoCliente].background= ContextCompat.getDrawable(this, R.drawable.radio_disabled)
                }else if(asientoCliente<11){
                    row2[asientoCliente-5].background= ContextCompat.getDrawable(this, R.drawable.radio_disabled)
                }else if(asientoCliente<16){
                    row3[asientoCliente-10].background= ContextCompat.getDrawable(this, R.drawable.radio_disabled)
                }else{
                    row4[asientoCliente-15].background= ContextCompat.getDrawable(this, R.drawable.radio_disabled)
                }
            }
        }


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

        confirm.setOnClickListener {
            while(asiento > 20)asiento -= 20
            var error = false
            for(clients in peliculas?.get(pos)?.seats!!){
                if(clients.asiento == asiento){
                    Toast.makeText(this,"¡Este asiento está ocupado!", Toast.LENGTH_LONG).show()
                    error = true
                }
            }

            if(asiento == -1){
                Toast.makeText(this,"¡Debes escoger un asiento antes de proceder!", Toast.LENGTH_LONG).show()
            }else if(!error){
                val intento:Intent=Intent(this,Resume::class.java)
                intento.putExtra("asiento",asiento)
                intento.putExtra("titulo",bundle?.getString("name"))
                this.startActivity(intento)
            }
        }
    }
}

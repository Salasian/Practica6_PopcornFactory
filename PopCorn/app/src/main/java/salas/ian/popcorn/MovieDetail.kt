package salas.ian.popcorn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MovieDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        var bundle= intent.extras
        var seatsLeft=0
        var title=""
        var pos=0

        if(bundle!=null) {

        seatsLeft = bundle.getInt("numberSeats")
        title= bundle.getString("titulo")!!
        var detailImage = findViewById<ImageView>(R.id.detail_view)
        var detailTitle = findViewById<TextView>(R.id.detail_title)
        var detailDescription = findViewById<TextView>(R.id.detail_desc)
        var seats = findViewById<TextView>(R.id.seatsLeft)

        detailImage.setImageResource(bundle.getInt("image"))
        detailTitle.text = title
        detailDescription.text = bundle.getString("sinopsis")
        seats.text="$seatsLeft seats available"
        pos=bundle.getInt("pos")
        }
        var tickets = findViewById<Button>(R.id.buyTickets)
        if(seatsLeft==0){
            tickets.isEnabled = false
        }else{
            tickets.isEnabled = true
            tickets.setOnClickListener {
                val intento: Intent = Intent(this,SeatsSelection::class.java)
                intento.putExtra("name",title)
                intento.putExtra("pos",pos)
                this.startActivity(intento)
            }
        }

    }
}
package salas.ian.popcorn

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MovieDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        var image = intent.getIntExtra("image", 0)
        var titulo = intent.getStringExtra("titulo")
        var header = intent.getIntExtra("header", 0)
        var sinopsis = intent.getStringExtra("sinopsis")

        var detailImage = findViewById<ImageView>(R.id.detail_view)
        var detailTitle = findViewById<TextView>(R.id.detail_title)
        var detailDescription = findViewById<TextView>(R.id.detail_desc)

        detailImage.setImageResource(image)
        detailTitle.text = titulo
        detailDescription.text = sinopsis
    }
}
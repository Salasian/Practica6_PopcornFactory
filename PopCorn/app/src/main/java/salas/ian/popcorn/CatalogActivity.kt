package salas.ian.popcorn

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView


class CatalogActivity : AppCompatActivity() {

    var adapter: PeliculaAdapter? = null
    var seriesAdapter:PeliculaAdapter?= null
    var peliculas = ArrayList<Pelicula>()
    var series =ArrayList<Pelicula>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)
        cargarPelicula()
        adapter = PeliculaAdapter(this,peliculas)
        seriesAdapter = PeliculaAdapter(this,series)

        var gridPelis :GridView= findViewById(R.id.movies_catalog)
        var gridSeries :GridView= findViewById(R.id.series_catalog)

        gridPelis.adapter = adapter
        gridSeries.adapter=seriesAdapter
    }

    fun cargarPelicula(){
        peliculas.add(Pelicula("Big Hero 6",R.drawable.bighero6, R.drawable.headerbighero6, "When a devastating event befalls the city of San Fransokyo and catapults Hiro into the midst of danger, he turns to Baymax and his close friends adrenaline junkie Go Go Tomago, neatnik Wasabi, chemistry whiz Honey Lemon and fanboy Fred. Determined to uncover the mystery, Hiro transforms his friends into a band of high-tech heroes called ‘Big Hero 6.’"))
        peliculas.add(Pelicula("Inception",R.drawable.inception, R.drawable.inceptionheader, "Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing valuable secrets from deep within the subconscious during the dream state, when the mind is at its most vulnerable. Cobb's rare ability has made him a coveted player in this treacherous new world of corporate espionage, but it has also made him an international fugitive and cost him everything he has ever loved. Now Cobb is being offered a chance at redemption. One last job could give him his life back but only if he can accomplish the impossible, inception. Instead of the perfect heist, Cobb and his team of specialists have to pull off the reverse: their task is not to steal an idea, but to plant one. If they succeed, it could be the perfect crime. But no amount of careful planning or expertise can prepare the team for the dangerous enemy that seems to predict their every move. An enemy that only Cobb could have seen coming."))
        peliculas.add(Pelicula("Leap Year", R.drawable.leapyear, R.drawable.leapyearheader, "A woman who has an elaborate scheme to propose to her boyfriend on Leap Day, an Irish tradition which occurs every time the date February 29 rolls around, faces a major setback when bad weather threatens to derail her planned trip to Dublin. With the help of an innkeeper, however, her cross-country odyssey just might result in her getting engaged."))
        peliculas.add(Pelicula("Toy Story", R.drawable.toystory, R.drawable.toystoryheader, "Toy Story is about the 'secret life of toys' when people are not around. When Buzz Lightyear, a space-ranger, takes Woody's place as Andy's favorite toy, Woody doesn't like the situation and gets into a fight with Buzz. Accidentaly Buzz falls out the window and Woody is accused by all the other toys of having killed him. He has to go out of the house to look for him so that they can both return to Andys room. But while on the outside they get into all kind of trouble while trying to get home." ))
        peliculas.add(Pelicula("1917",R.drawable.nineteenseventeen, R.drawable.nineteenseventeenheader,"On 6 April 1917, aerial reconnaissance has observed that the German army, which has pulled back from a sector of the Western Front in northern France, is not in retreat but has made a strategic withdrawal to the new Hindenburg Line, where they are waiting to overwhelm the British with artillery."))
        peliculas.add(Pelicula("Men in black",R.drawable.mib, R.drawable.mibheader, "After a government agency makes first contact with aliens in 1961, alien refugees live in secret on Earth by disguising themselves as humans. Men in Black (MIB) is a secret agency that polices these aliens, protects Earth from extraterrestrial threats, and uses memory-erasing neuralyzers to keep alien activity a secret. MIB agents have their former identities erased while retired agents are neuralyzed. "))


    }

    class PeliculaAdapter: BaseAdapter {
        var context:Context?=null
        var peliculas = ArrayList<Pelicula>()

        constructor(context:Context,peliculas:ArrayList<Pelicula>){
            this.context=context
            this.peliculas=peliculas
        }

        override fun getCount(): Int {
            return peliculas.size
        }

        override fun getItem(p0: Int): Any {
            return peliculas[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var pelicula = peliculas[p0]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflator.inflate(R.layout.cell_movie,null)
            var image: ImageView = vista.findViewById(R.id.image_movie_cell)
            var title:TextView = vista.findViewById(R.id.movie_title_cell)

            image.setImageResource(pelicula.image)
            title.setText(pelicula.titulo)

            image.setOnClickListener{
                var intento = Intent(context,MovieDetail::class.java)
                intento.putExtra("titulo",pelicula.titulo)
                intento.putExtra("sinopsis",pelicula.sinopsis)
                intento.putExtra("header",pelicula.header)
                intento.putExtra("image",pelicula.image)
                context!!.startActivity(intento)
            }
            return vista

        }
    }
}
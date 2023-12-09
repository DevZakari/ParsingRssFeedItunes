package hello.app.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import android.widget.ImageView
import com.squareup.picasso.Picasso


import hello.app.R
import hello.app.model.Entry

class TopSongsAdapter : RecyclerView.Adapter<TopSongsAdapter.ViewHolder>() {

    private var topSongs: List<Entry> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_top_song, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val topSong = topSongs[position]
        holder.bind(topSong)
    }

    override fun getItemCount(): Int {
        return topSongs.size
    }

    fun setData(data: List<Entry>?) {
        data?.let {
            topSongs = it
            notifyDataSetChanged()
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView = itemView.findViewById<TextView>(R.id.titleTextView)
        private val nameTextView = itemView.findViewById<TextView>(R.id.nameTextView)
        private val categoryTextView = itemView.findViewById<TextView>(R.id.categoryTextView)
        private val imageView = itemView.findViewById<ImageView>(R.id.imageView)

        fun bind(entry: Entry) {
            titleTextView.text = entry.title
            nameTextView.text = entry.name

            // Vérifiez si la catégorie existe avant de l'afficher
            entry.category?.let { category ->
                // Affichez les informations de la catégorie
                val categoryInfo = "Category: ${category.label}"
                categoryTextView.text = categoryInfo
            }
            Picasso.get().load("https://daily.jstor.org/wp-content/uploads/2023/01/good_times_with_bad_music_1050x700.jpg").into(imageView)
        }
    }



}

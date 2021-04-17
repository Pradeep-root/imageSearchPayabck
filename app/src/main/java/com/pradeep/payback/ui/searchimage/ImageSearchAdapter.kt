package com.pradeep.payback.ui.searchimage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pradeep.payback.R
import com.pradeep.payback.data.model.ImageData

class ImageSearchAdapter(val imageList : ArrayList<ImageData>) : RecyclerView.Adapter<ImageSearchAdapter.ViewHolder>(){

    private lateinit var context : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageSearchAdapter.ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.img_search_item,
                parent,
                false
            )
        )
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(imageData: ImageData){

        }
    }

    override fun onBindViewHolder(holder: ImageSearchAdapter.ViewHolder, position: Int) {
        holder.bind(imageList[position])
    }

    override fun getItemCount(): Int {
      return imageList.size
    }

    fun updateList(newMovies: MutableList<ImageData>){
        imageList.clear()
        imageList.addAll(newMovies)
        notifyDataSetChanged()
    }
}
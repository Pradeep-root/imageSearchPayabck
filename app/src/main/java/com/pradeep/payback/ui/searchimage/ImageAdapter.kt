package com.pradeep.payback.ui.searchimage

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pradeep.payback.data.model.ImageData
import com.pradeep.payback.databinding.ImgSearchItemBinding

class ImageAdapter(val imageList : ArrayList<ImageData>) : RecyclerView.Adapter<ImageAdapter.ViewHolder>(){

    private lateinit var context : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapter.ViewHolder {
        context = parent.context
        val layoutInflater = LayoutInflater.from(context)
        val binding = ImgSearchItemBinding.inflate(layoutInflater)
        return ViewHolder(binding)
    }

    inner class ViewHolder(val binding: ImgSearchItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: ImageAdapter.ViewHolder, position: Int) {
        val imageData = imageList[position]
        holder.binding.imgData = imageData
        holder.binding.cardView.setOnClickListener {
            //TODO open activity
        }
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
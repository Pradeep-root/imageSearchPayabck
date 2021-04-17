package com.pradeep.payback.ui.searchimage

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.pradeep.payback.R
import com.pradeep.payback.data.model.ImageData
import com.pradeep.payback.databinding.ImgSearchItemBinding
import com.pradeep.payback.ui.imagedetail.ImageDetailActivity
import com.pradeep.payback.utils.Constants.Companion.IMG_DATA_PUT_EXTRA_KEY
import com.pradeep.payback.utils.hideKeyboard

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
            showConfirmationDialog(imageData)
            holder.binding.root.hideKeyboard()
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

    private fun showConfirmationDialog(imageData: ImageData){
        val alertDialog = AlertDialog.Builder(context).create()
        alertDialog.setTitle(context.getString(R.string.confirmation_dialog_to_open_detail))
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, context.getString(R.string.yes)) { _, i ->
            openDetailActivity(imageData)
        }
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, context.getString(R.string.no)) { _, i ->
            alertDialog.dismiss()
        }
        alertDialog.show()
    }

    private fun openDetailActivity(imageData: ImageData){
        Intent(context, ImageDetailActivity::class.java).apply {
            putExtra(IMG_DATA_PUT_EXTRA_KEY, imageData)
            context.startActivity(this)
        }
    }
}
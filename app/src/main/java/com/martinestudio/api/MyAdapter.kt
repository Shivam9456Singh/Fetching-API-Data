package com.martinestudio.api

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Activity, val productArrayList:List<MyData.Product>):
RecyclerView.Adapter<MyAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.eachitem,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = productArrayList[position]
        holder.title.text = currentItem.title
        holder.price.text = currentItem.price.toString()
        holder.brand.text = "Brand: "+ currentItem.brand
        holder.rating.text = "Rating: "+currentItem.rating.toString()
        holder.description.text = currentItem.description.toString()

        // showing image in imageview from image url
        // using picasso third party library.

        Picasso.get().load(currentItem.thumbnail).into(holder.image)

    }

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var title:TextView
        var image:ShapeableImageView
        var price:TextView
        var brand:TextView
        var rating:TextView
        var description:TextView


        init {
            title = itemView.findViewById(R.id.productTitle)
            image = itemView.findViewById(R.id.productImage)
            price = itemView.findViewById(R.id.productPrice)
            brand = itemView.findViewById(R.id.productBrand)
            rating = itemView.findViewById(R.id.productRating)
            description = itemView.findViewById(R.id.productDescription)

        }
    }
}
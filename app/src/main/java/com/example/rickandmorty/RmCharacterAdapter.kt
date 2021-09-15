package com.example.rickandmorty

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RmCharacterAdapter(val rmList: List<RmCharacter>) :
            RecyclerView.Adapter<RmCharacterAdapter.RmViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RmViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
            return RmViewHolder(view)
        }

        override fun onBindViewHolder(holder: RmViewHolder, position: Int) {
            holder.textViewName.text = rmList[position].name
            Glide.with(holder.itemView.context).load(rmList[position].image)
                    .into(holder.imageViewAvatar)
        }

        override fun getItemCount(): Int {
            return rmList.size
        }

        class RmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val imageViewAvatar: ImageView = itemView.findViewById(R.id.imageViewAvatar)
            val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        }
    }


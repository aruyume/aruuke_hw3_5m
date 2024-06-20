package com.example.aruuke_hw3_5m

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aruuke_hw3_5m.databinding.ItemCharacterBinding
import com.example.aruuke_hw3_5m.models.Character

class RickAdapter : RecyclerView.Adapter<RickAdapter.ViewHolder>() {

    private var list = ArrayList<Character>()

    fun setData(list: List<Character>) {
        this.list = list as ArrayList<Character>
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val characterImage = binding.characterImage
        val name = binding.showName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCharacterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView).load(list[position].image).into(holder.characterImage)
        holder.name.text = list[position].name
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
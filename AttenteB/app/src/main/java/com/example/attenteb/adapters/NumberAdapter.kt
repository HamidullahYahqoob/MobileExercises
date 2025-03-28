package com.example.attenteb.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.attenteb.databinding.NumberItemBinding
import com.example.attenteb.models.Number

class NumberAdapter : ListAdapter<Number, NumberAdapter.NumberItemViewHolder>(NumberItemDiffCallback) {

    inner class NumberItemViewHolder(private val binding: NumberItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(number: Number) {
            binding.tvPrenom.text = number.nombre.toString()
            binding.nombre.text = number.cmb.toString()

        }
    }

    object NumberItemDiffCallback : DiffUtil.ItemCallback<Number>() {
        override fun areItemsTheSame(oldItem: Number, newItem: Number): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Number, newItem: Number): Boolean {
            return oldItem.nombre == newItem.nombre
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberItemViewHolder {
        val binding: NumberItemBinding = NumberItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NumberItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NumberItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
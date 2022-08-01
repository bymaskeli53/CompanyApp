package com.example.companyapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.companyapp.databinding.ItemRvDialogBinding
import com.example.companyapp.model.DialogModel

class DialogAdapter(val dialogList: List<DialogModel>) : RecyclerView.Adapter<DialogAdapter.DialogViewHolder>() {



    inner class DialogViewHolder(val binding: ItemRvDialogBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DialogViewHolder {
        val binding = ItemRvDialogBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DialogViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DialogViewHolder, position: Int) {
        val position = dialogList[position]
        holder.binding.checkbox.isChecked = position.checked
        holder.binding.textViewJob.text = position.job
        holder.binding.textViewName.text = position.name
        holder.binding.roundedImageView.setImageResource(position.resId)

    }

    override fun getItemCount() = dialogList.size


}
package com.example.companyapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.companyapp.model.Member
import com.example.companyapp.databinding.ItemPersonBinding

class MembersAdapter(private val membersList: List<Member>) : RecyclerView.Adapter<MembersAdapter.MembersViewHolder>() {


    inner class MembersViewHolder(val binding: ItemPersonBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MembersViewHolder {
            val binding = ItemPersonBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return MembersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MembersViewHolder, position: Int) {
//        with(holder) {
//            with(membersList[position]) {
//
//            }
//        }
        val position = membersList[position]
        holder.binding.apply {
            textViewJob.text = position.job
            textViewName.text = position.name
            roundedImageView.setImageResource(position.imageId)
        }

    }

    override fun getItemCount() = membersList.size
}
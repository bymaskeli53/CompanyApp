package com.example.companyapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.companyapp.model.Member
import com.example.companyapp.databinding.ItemPersonBinding
import com.example.companyapp.model.DialogModel

class MembersAdapter(private val membersList: ArrayList<DialogModel>) : RecyclerView.Adapter<MembersAdapter.MembersViewHolder>() {


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
            //textViewJob.text = position.job?
            position.job?.let { textViewJob.text = position.job }
           // textViewName.text = position.name
            position.name?.let { textViewName.text = position.name }
            position.resId?.let { roundedImageView.setImageResource(it) }
        }

        if (!position.checked){
            holder.binding.textViewCompanyManager.visibility = View.GONE
        } else {
            holder.binding.textViewCompanyManager.visibility = View.VISIBLE
        }

    }

    override fun getItemCount() = membersList.size
}
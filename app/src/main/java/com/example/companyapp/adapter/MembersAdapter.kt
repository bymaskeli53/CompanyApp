package com.example.companyapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.companyapp.BottomSheet
import com.example.companyapp.databinding.ItemPersonBinding
import com.example.companyapp.model.DialogModel

class MembersAdapter(private val membersList: ArrayList<DialogModel>,val context: Context) : RecyclerView.Adapter<MembersAdapter.MembersViewHolder>() {


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
        val item = membersList[position]

        holder.binding.apply {
            //textViewJob.text = position.job?
            item.job?.let { textViewJob.text = item.job }
           // textViewName.text = position.name
            item.name?.let { textViewName.text = item.name }
            item.resId?.let { roundedImageView.setImageResource(it) }
        }

        if (!item.checked){
            holder.binding.textViewCompanyManager.visibility = View.GONE
        } else {
            holder.binding.textViewCompanyManager.visibility = View.VISIBLE
        }

        holder.itemView.setOnClickListener {
            onItemClicked(item,position,context)

        }


    }

    override fun getItemCount() = membersList.size

    private fun onItemClicked(item: DialogModel, position: Int,context: Context) {
            val bottomSheet = BottomSheet(context = context)

            bottomSheet.showBottomDialog(item)
    }

}
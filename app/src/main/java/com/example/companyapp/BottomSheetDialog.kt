package com.example.companyapp

import android.content.Context
import android.view.LayoutInflater
import com.example.companyapp.databinding.BottomSheetDialogBinding
import com.example.companyapp.model.DialogModel
import com.google.android.material.bottomsheet.BottomSheetDialog

class BottomSheet(val context: Context) {
    private lateinit var binding: BottomSheetDialogBinding
    fun showBottomDialog(item: DialogModel) {
        binding = BottomSheetDialogBinding.inflate(LayoutInflater.from(context))
        binding.textViewName.text = item.name
        binding.textViewJob.text = item.job

        item.resId?.let { binding.imageView.setImageResource(it) }
        val bottomSheetDialog = BottomSheetDialog(context)
        bottomSheetDialog.setContentView(binding.root)
        bottomSheetDialog.show()

        binding.closeButton.setOnClickListener {
            bottomSheetDialog.dismiss()
        }
    }
}
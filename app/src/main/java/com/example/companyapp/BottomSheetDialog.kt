package com.example.companyapp

import android.content.Context
import com.google.android.material.bottomsheet.BottomSheetDialog

class BottomSheet(val context: Context) {
    fun showBottomDialog() {
        val bottomSheetDialog = BottomSheetDialog(context)
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog)
        bottomSheetDialog.show()
    }
}
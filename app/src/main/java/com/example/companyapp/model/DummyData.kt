package com.example.companyapp.model

import com.example.companyapp.R

object DummyData {
    var dialogList : ArrayList<DialogModel> = arrayListOf()

    init {
       dialogList.add(DialogModel(resId = R.drawable.dicaprio, name = "Dicaprio", job = "actor", checked = false))
       dialogList.add(DialogModel(resId = R.drawable.brad, name = "Brad Pitt", job = "actor", checked = false))
       dialogList.add(DialogModel(resId = R.drawable.ben, name = "Muhammet", job = "software engineer", checked = false))
       dialogList.add(DialogModel(resId = R.drawable.dicaprio, name = "John", job = "designer", checked = false))
       dialogList.add(DialogModel(resId = R.drawable.max, name = "Verstappen", job = "f1 driver", checked = false))
   }

}
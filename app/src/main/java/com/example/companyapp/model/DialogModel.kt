package com.example.companyapp.model

data class DialogModel(
    var checked: Boolean = false,
    val resId: Int? = null,
    val name: String? = null,
    val job: String? = null
) {
}
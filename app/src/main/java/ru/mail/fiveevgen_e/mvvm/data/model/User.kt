package ru.mail.fiveevgen_e.mvvm.data.model

import com.google.gson.annotations.SerializedName

// Для возможности тестирования поля var, а не val
data class User(
    var id: Int = 0,
    var name: String = "",
    var email: String = "",
    var avatar: String = ""
)

//data class User(
//    @SerializedName("id")
//    val id: Int = 0,
//
//    @SerializedName("name")
//    val name: String = "",
//
//    @SerializedName("email")
//    val email: String = "",
//
//    @SerializedName("avatar")
//    val avatar: String = ""
//)
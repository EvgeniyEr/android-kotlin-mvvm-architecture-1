package ru.mail.fiveevgen_e.mvvm.data.api

import io.reactivex.Single
import ru.mail.fiveevgen_e.mvvm.data.model.User

interface ApiService {

    fun getUsers(): Single<List<User>>
}
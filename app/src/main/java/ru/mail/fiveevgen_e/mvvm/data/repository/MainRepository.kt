package ru.mail.fiveevgen_e.mvvm.data.repository

import io.reactivex.Single
import ru.mail.fiveevgen_e.mvvm.data.api.ApiService
import ru.mail.fiveevgen_e.mvvm.data.model.User

class MainRepository(private val apiService: ApiService) {

    // Single - однократное получение данных
    fun getUsers(): Single<List<User>> {
        return apiService.getUsers()
    }
}
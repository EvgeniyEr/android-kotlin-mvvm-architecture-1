package ru.mail.fiveevgen_e.mvvm.data.api

import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single
import ru.mail.fiveevgen_e.mvvm.data.model.User

class RemoteDataSource : ApiService {

//    override fun getUsers(): Single<List<User>> {
//        return Rx2AndroidNetworking.get("https://5e510330f2c0d300147c034c.mockapi.io/users")
//            .build()
//            .getObjectListSingle(User::class.java)
//    }

    // Тестовый метод
    override fun getUsers(): Single<List<User>> {
        val user1 = User(
            1,
            "Dr. Edwin Orn",
            "Connor.Hartmann71@gmail.com",
            "https://jsonparsingdemo-cec5b.firebaseapp.com/jsonData/images/avengers.jpg"
        )
        val user2 = User(
            2,
            "Alford Hoeger",
            "Rick83@gmail.com",
            "https://jsonparsingdemo-cec5b.firebaseapp.com/jsonData/images/interstellar.jpg"
        )
        val user3 = User(
            3,
            "Terrance Halvorson",
            "Kenton_Wisozk@hotmail.com",
            "https://jsonparsingdemo-cec5b.firebaseapp.com/jsonData/images/f_four.jpg"
        )
        val user4 = User(
            4,
            "Dr. Edwin Orn",
            "Connor.Hartmann71@gmail.com",
            "https://jsonparsingdemo-cec5b.firebaseapp.com/jsonData/images/life_is_beautiful.jpg"
        )
        val user5 = User(
            5,
            "Alford Hoeger",
            "Rick83@gmail.com",
            "https://jsonparsingdemo-cec5b.firebaseapp.com/jsonData/images/gladiator.jpg"
        )
        val user6 = User(
            6,
            "Terrance Halvorson",
            "Kenton_Wisozk@hotmail.com",
            "https://jsonparsingdemo-cec5b.firebaseapp.com/jsonData/images/lion.jpg"
        )
        return Single.just(listOf(user1, user2, user3, user4, user5, user6))
    }
}
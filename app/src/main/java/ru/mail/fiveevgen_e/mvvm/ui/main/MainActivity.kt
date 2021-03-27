package ru.mail.fiveevgen_e.mvvm.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
// Чтобы можно было напрямую по id обращаться к View ( и не использовать findViewById() )
import kotlinx.android.synthetic.main.activity_main.*
import ru.mail.fiveevgen_e.mvvm.R
import ru.mail.fiveevgen_e.mvvm.ui.users.view.UsersActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonDownloadUsers.setOnClickListener {
            val intent = Intent(this, UsersActivity::class.java)
            startActivity(intent)
        }
    }
}
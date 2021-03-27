package ru.mail.fiveevgen_e.mvvm.ui.users.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_users.*
import ru.mail.fiveevgen_e.mvvm.R
import ru.mail.fiveevgen_e.mvvm.data.model.User
import ru.mail.fiveevgen_e.mvvm.ui.users.adapter.UsersAdapter
import ru.mail.fiveevgen_e.mvvm.ui.users.viewmodel.UsersViewModel
import ru.mail.fiveevgen_e.mvvm.utils.Status


class UsersActivity : AppCompatActivity() {

    private lateinit var mUsersViewModel: UsersViewModel
    private lateinit var mAdapter: UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)
        setupUI()
        setupViewModel()
        setupObserver()
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter = UsersAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = mAdapter
    }

    private fun setupViewModel() {
        mUsersViewModel = ViewModelProviders.of(this).get(UsersViewModel::class.java)
    }

    private fun setupObserver() {
        mUsersViewModel.getUsers().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    // let часто используется для выполнения блока кода только с non-null значениями.
                    // Чтобы выполнить действия с non-null объектом, используйте оператор безопасного
                    // вызова ?. совместно с функцией let
                    it.data?.let { users -> renderList(users) }
                    recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(users: List<User>) {
        mAdapter.addData(users)
        mAdapter.notifyDataSetChanged() // уведомляем, чтобы список перерисовался
    }
}
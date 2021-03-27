package ru.mail.fiveevgen_e.mvvm.ui.users.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.mail.fiveevgen_e.mvvm.R
import ru.mail.fiveevgen_e.mvvm.data.model.User
import kotlinx.android.synthetic.main.users_item_layout.view.*

class UsersAdapter(
    private val mUsers: ArrayList<User>
) : RecyclerView.Adapter<UsersAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewUserName = itemView.textViewUserName
        var textViewUserEmail = itemView.textViewUserEmail
        var imageViewAvatar = itemView.imageViewAvatar
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.users_item_layout, parent,
            false
        )
        return DataViewHolder(itemView)
    }

    override fun getItemCount(): Int = mUsers.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val user = mUsers.get(position)
        holder.textViewUserName.text = user.name
        holder.textViewUserEmail.text = user.email

        Glide.with(holder.imageViewAvatar.context)
                .load(user.avatar) // Загрузка аватарки
                .into(holder.imageViewAvatar)
    }

    fun addData(list: List<User>) {
        mUsers.addAll(list)
    }
}
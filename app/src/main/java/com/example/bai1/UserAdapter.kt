package com.example.bai1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val userList: MutableList<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName: TextView = itemView.findViewById(R.id.nameTextView)
        val textViewEmail: TextView = itemView.findViewById(R.id.emailTextView)
        val textViewPhone: TextView = itemView.findViewById(R.id.phoneTextView)
        val textViewGender: TextView = itemView.findViewById(R.id.genderTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)

        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.textViewName.text = user.name
        holder.textViewEmail.text = "Email: ${user.email}"
        holder.textViewPhone.text = "Số điện thoại: ${user.phone}"
        holder.textViewGender.text = "Giới tính: ${user.gender}"
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    // Phương thức thêm user mới vào danh sách
    fun addUser(user: User) {
        userList.add(user)
        notifyItemInserted(userList.size - 1)
    }
}

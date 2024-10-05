package com.example.bai1

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var genderRadioGroup: RadioGroup
    private lateinit var termsCheckBox: CheckBox
    private lateinit var saveButton: Button
    private lateinit var userRecyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter
    private val userList: MutableList<User> = mutableListOf() // Sử dụng MutableList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        nameEditText = findViewById(R.id.nameEditText)
        emailEditText = findViewById(R.id.emailEditText)
        phoneEditText = findViewById(R.id.phoneEditText)
        genderRadioGroup = findViewById(R.id.genderRadioGroup)
        termsCheckBox = findViewById(R.id.termsCheckBox)
        saveButton = findViewById(R.id.saveButton)
        userRecyclerView = findViewById(R.id.userRecyclerView)

        // Set up RecyclerView
        userRecyclerView.layoutManager = LinearLayoutManager(this)
        userAdapter = UserAdapter(userList) // Khởi tạo với danh sách MutableList
        userRecyclerView.adapter = userAdapter

        // Handle save button click
        saveButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val phone = phoneEditText.text.toString().trim()

            val genderId = genderRadioGroup.checkedRadioButtonId
            val gender = when (genderId) {
                R.id.radioMale -> "Nam"
                R.id.radioFemale -> "Nữ"
                R.id.radioOther -> "Khác"
                else -> ""
            }

            if (name.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty() && gender.isNotEmpty() && termsCheckBox.isChecked) {
                // Thêm thông tin người dùng vào RecyclerView
                userAdapter.addUser(User(name, email, phone, gender))
                clearInputFields()
                Toast.makeText(this, "Lưu thông tin thành công!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin và chấp nhận điều khoản.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun clearInputFields() {
        nameEditText.text.clear()
        emailEditText.text.clear()
        phoneEditText.text.clear()
        genderRadioGroup.clearCheck()
        termsCheckBox.isChecked = false
    }
}

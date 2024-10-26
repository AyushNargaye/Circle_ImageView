package com.example.applicationview

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import de.hdodenhof.circleimageview.CircleImageView

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user)

        val name = intent.getStringExtra("name")
        val phoneNumber = intent.getStringExtra("phone")
        val imageId = intent.getIntExtra("imageId", R.drawable.ayush)

        val nameTv = findViewById<TextView>(R.id.tName)
        val phone = findViewById<TextView>(R.id.tvPhone)
        val image = findViewById<CircleImageView>(R.id.profileImage)

        nameTv.text = name
        phone.text = phoneNumber
        image.setImageResource(imageId)
    }
}
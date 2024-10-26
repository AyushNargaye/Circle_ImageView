package com.example.applicationview

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var userArrayList: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val name = arrayOf("Ayush", "Tom", "RDJ", "Hugh", "Ana De Armas")

        val lastMsg = arrayOf("Hey Wassup?", "I am fine!", "I am Iron Man", " I am Wolerine", "I am an Actress" )

        val lastMsgTime = arrayOf("3:59 PM", "6:25 PM", "9:15 AM", "5:26", "7:15")

        val phoneNumber = arrayOf("9632547238", "9987532452", "6252997781", "7089661896", "8519361179")

        val imageId = intArrayOf(R.drawable.ayush, R.drawable.tom_cruise, R.drawable.rdj, R.drawable.hugh_jackman, R.drawable.anadearmas2 )

        userArrayList = ArrayList()

        for (eachIndex in name.indices){
            val user = User(name[eachIndex], lastMsg[eachIndex], lastMsgTime[eachIndex], phoneNumber[eachIndex], imageId[eachIndex] )

            userArrayList.add(user)
        }
        val listView = findViewById<ListView>(R.id.listView)
        listView.isClickable = true
        listView.adapter = MyAdapter(this, userArrayList)

        listView.setOnItemClickListener { parent, view, position, id ->
            // open new activity
            val userName = name[position]
            val userPhone = phoneNumber[position]
            val imageId =  imageId[position]

            val  i = Intent(this, UserActivity::class.java)
            i.putExtra("name", userName)
            i.putExtra("phone", userPhone)
            i.putExtra("imageId", imageId)
            startActivity(i)

        }
    }
}
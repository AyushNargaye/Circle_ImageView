package com.example.applicationview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapter (val context : Activity, val arrayList: ArrayList<User>) :
    ArrayAdapter<User>(context, R.layout.eachitem, arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.eachitem, null)
        val image = view.findViewById<CircleImageView>(R.id.profileImage)
        val name = view.findViewById<TextView>(R.id.tName)
        val lastMsg = view.findViewById<TextView>(R.id.lastMsg)
        val lastMsgTime = view.findViewById<TextView>(R.id.lastMsgTime)

        name.text = arrayList[position].name
        lastMsg.text = arrayList[position].lastMsg
        lastMsgTime.text = arrayList[position].lastMsgTime
        image.setImageResource(arrayList[position].imageId)

        return view // super.getView(position, convertView, parent)
    }
}
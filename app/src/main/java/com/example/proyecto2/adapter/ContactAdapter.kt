package com.example.proyecto2.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto2.R
import com.example.proyecto2.model.Contact

class ContactAdapter(private val contactList: ArrayList<Contact>, private val onItemClicked: (Contact) -> Unit):  RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.contactNameTV)
        val phone: TextView = view.findViewById(R.id.contactPhoneNumberTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        runCatching {
            holder.name.text = contactList[position].name
            holder.phone.text = contactList[position].phone
            holder.itemView.setOnClickListener {
                onItemClicked.invoke(contactList[position])
            }

        }.onFailure {
            Log.e("ContactAdapter", it.message.toString())
        }
    }

    override fun getItemCount(): Int = contactList.size
}
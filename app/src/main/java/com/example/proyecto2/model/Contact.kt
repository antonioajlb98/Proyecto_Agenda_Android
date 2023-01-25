package com.example.proyecto2.model

import java.util.*

data class Contact(val id: String = UUID.randomUUID().toString(), val name: String, val phone: String)
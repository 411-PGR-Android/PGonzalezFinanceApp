package com.example.pgonzlezfinanceappp.models

data class User(
    val name: String,
    val balance: Double
)

val currentUser = User(
    name = "Paulina",
    balance = 1250.00
)
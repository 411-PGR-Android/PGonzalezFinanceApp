package com.example.pgonzlezfinanceappp.models

import androidx.compose.ui.graphics.vector.ImageVector

data class Transaction(
    val name: String,
    val category: String,
    val amount: Double,
    val time: String,
    val icon: ImageVector
)
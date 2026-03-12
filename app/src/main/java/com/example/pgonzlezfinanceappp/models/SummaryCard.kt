package com.example.pgonzlezfinanceappp.models

import androidx.compose.ui.graphics.Color

data class SummaryCard(
    val title: String,
    val amount: Double,
    val backgroundColor: Color
)

val summaryCards = listOf(
    SummaryCard("Actividad", 520.00, Color(0xFFE8F5E9)),
    SummaryCard("Ventas", 280.99, Color(0xFFF5F0E8)),
    SummaryCard("Ganancias", 280.99, Color(0xFFEDE7F6))
)
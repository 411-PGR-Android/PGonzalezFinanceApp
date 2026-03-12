package com.example.pgonzlezfinanceappp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pgonzlezfinanceappp.models.Transaction


@Composable
fun TransactionItem(transaction: Transaction) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // icono
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(Color.Black),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = transaction.icon,
                contentDescription = transaction.name,
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }

        // nombre y categoria
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 12.dp)
        ) {
            Text(
                text = transaction.name,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
            Text(
                text = transaction.category,
                color = Color.Gray,
                fontSize = 13.sp
            )
        }

        // monto y hura
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = if (transaction.amount >= 0) "$${transaction.amount}" else "-$${Math.abs(transaction.amount)}",
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                color = Color.Black
            )
            Text(
                text = transaction.time,
                color = Color.Gray,
                fontSize = 12.sp
            )
        }
    }
}
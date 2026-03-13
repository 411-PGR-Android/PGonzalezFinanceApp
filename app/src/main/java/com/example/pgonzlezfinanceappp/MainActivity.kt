package com.example.pgonzlezfinanceappp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pgonzlezfinanceappp.components.TransactionItem
import com.example.pgonzlezfinanceappp.models.summaryCards
import com.example.pgonzlezfinanceappp.models.Transaction
import com.example.pgonzlezfinanceappp.models.currentUser
import com.example.pgonzlezfinanceappp.models.summaryCards
import com.example.pgonzlezfinanceappp.ui.theme.PGonzálezFinanceApppTheme
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.PaddingValues
import com.example.pgonzlezfinanceappp.models.SummaryCard


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PGonzálezFinanceApppTheme() {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(innerPadding)
                }
            }
        }
    }
}

val transactionList = listOf(
    Transaction("Supermarket", "Groceries", 45.99, "10:30 AM", Icons.Default.ShoppingCart),
    Transaction("Gas Station", "Fuel", -30.50, "12:15 PM", Icons.Default.ShoppingCart),
    Transaction("Coffee Shop", "Food & Drinks", 5.75, "8:00 AM", Icons.Default.ShoppingCart),
    Transaction("Electronics Store", "Electronics", 120.0, "3:45 PM", Icons.Default.ShoppingCart),
    Transaction("Bookstore", "Books", 25.99, "2:00 PM", Icons.Default.ShoppingCart),
    Transaction("Restaurant", "Dining", 60.0, "7:30 PM", Icons.Default.ShoppingCart)
)

@Composable
fun HomeScreen(innerPadding: PaddingValues) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = 20.dp, vertical = 10.dp)
    ) {
        //header
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Avatar",
                            modifier = Modifier.fillMaxSize(),
                            tint = Color.DarkGray
                        )
                    }
                    Column(modifier = Modifier.padding(start = 10.dp)) {
                        Text(
                            text = "Hola ${currentUser.name}",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Text(
                            text = "Bienvenido",
                            color = Color.Gray,
                            fontSize = 13.sp
                        )
                    }
                }
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menú",
                    modifier = Modifier.size(28.dp)
                )
            }
        }

        // tarjetas de resumen
        item {
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Tarjeta grande izquierda
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .height(180.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = summaryCards[0].backgroundColor
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Default.Face,
                            contentDescription = null,
                            modifier = Modifier.size(32.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = summaryCards[0].title,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                        Text(
                            text = "de la Semana",
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                    }
                }

                // Columna derecha con 2 tarjetas
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    summaryCards.drop(1).forEach { card ->
                        SummaryCardItem(card)
                    }
                }
            }
        }

        // Transacciones header
        item {
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Transactions",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Text(
                    text = "See All",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }

        // Lista de transacciones
        items(transactionList) { transaction ->
            TransactionItem(transaction)
            HorizontalDivider(color = Color.LightGray, thickness = 0.5.dp)
        }
    }
}

@Composable
fun SummaryCardItem(card: SummaryCard) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(84.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = card.backgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = card.title,
                color = Color.Gray,
                fontSize = 12.sp
            )
            Text(
                text = "$${card.amount}",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }
    }
}
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HomeScreenPreview() {
    PGonzálezFinanceApppTheme {
        HomeScreen(
            innerPadding = PaddingValues(0.dp)
        )
    }
}
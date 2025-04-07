package com.example.expensetracker.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@Composable
fun TransactionItem(
    amount: Double,
    category: String,
    note: String,
    timestamp: Long,
    type: String, // "income" or "expense"
    iconUrl: String,
    modifier: Modifier = Modifier
) {
    val amountColor = if (type == "income") Color(0xFF4CAF50) else Color(0xFFF44336)
    val amountPrefix = if (type == "income") "+" else "-"
    val formattedDate = Instant.ofEpochMilli(timestamp)
        .atZone(ZoneId.systemDefault())
        .format(DateTimeFormatter.ofPattern("MMM dd"))

    Surface(
        modifier = modifier,
        color = Color.Transparent
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Left side - Icon and details
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Category icon
                Surface(
                    shape = MaterialTheme.shapes.small,
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.2f),
                    modifier = Modifier.size(40.dp)
                ) {
                    AsyncImage(
                        model = iconUrl,
                        contentDescription = category,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                // Category and note
                Column {
                    Text(
                        text = category,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.SemiBold
                    )
                    if (note.isNotBlank()) {
                        Text(
                            text = note,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                        )
                    }
                }
            }

            // Right side - Amount and date
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = "$amountPrefix$${"%.2f".format(amount)}",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.SemiBold
                    ),
                    color = amountColor
                )
                Text(
                    text = formattedDate,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }
        }
    }
}
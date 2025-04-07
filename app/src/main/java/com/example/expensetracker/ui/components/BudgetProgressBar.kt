package com.example.expensetracker.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.expensetracker.ui.theme.GlassPrimary

@Composable
fun BudgetProgressBar(
    budget: Double,
    spent: Double,
    modifier: Modifier = Modifier
) {
    val progress = (spent / budget).coerceIn(0f, 1f)
    val percentage = (progress * 100).toInt()
    val statusColor = when {
        progress > 0.9f -> Color(0xFFF44336) // Red
        progress > 0.7f -> Color(0xFFFF9800) // Orange
        else -> GlassPrimary // Default primary
    }

    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Budget",
                style = MaterialTheme.typography.labelMedium
            )
            Text(
                text = "$percentage% used (${"%.2f".format(spent)} / ${"%.2f".format(budget)})",
                style = MaterialTheme.typography.labelMedium,
                color = statusColor
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        LinearProgressIndicator(
            progress = progress.toFloat(),
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp),
            color = statusColor,
            trackColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.2f)
        )
    }
}
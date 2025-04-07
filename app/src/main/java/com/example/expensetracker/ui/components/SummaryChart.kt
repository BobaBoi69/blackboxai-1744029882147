package com.example.expensetracker.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.expensetracker.ui.theme.GlassPrimary

@Composable
fun SummaryChart(
    expensesByCategory: Map<String, Double>,
    modifier: Modifier = Modifier
) {
    val totalExpenses = expensesByCategory.values.sum()
    val sortedCategories = expensesByCategory.toList().sortedByDescending { it.second }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Expense Breakdown",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.height(16.dp))

        sortedCategories.forEach { (category, amount) ->
            val percentage = (amount / totalExpenses * 100).toInt()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = category,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.width(8.dp))

                LinearProgressIndicator(
                    progress = (amount / totalExpenses).toFloat(),
                    modifier = Modifier
                        .weight(2f)
                        .height(8.dp),
                    color = GlassPrimary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.2f)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "$percentage%",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }
        }
    }
}
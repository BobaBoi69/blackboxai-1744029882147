package com.example.expensetracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.expensetracker.ui.components.GlassCard
import com.example.expensetracker.ui.theme.GlassPrimary
import androidx.compose.material3.windowsizeclass.WindowSizeClass

@Composable
fun DashboardScreen(
    onAddTransaction: () -> Unit,
    windowSizeClass: WindowSizeClass
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header with glassmorphism effect
        GlassCard(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Total Balance",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "$1,234.56",
                    style = MaterialTheme.typography.displayMedium,
                    color = GlassPrimary
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Recent Transactions Section
        GlassCard(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Recent Transactions",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(8.dp))
                // Transaction list will go here
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Add Transaction Button
        Button(
            onClick = onAddTransaction,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clip(MaterialTheme.shapes.medium),
            colors = ButtonDefaults.buttonColors(
                containerColor = GlassPrimary,
                contentColor = Color.White
            )
        ) {
            Text("Add Transaction")
        }
    }
}
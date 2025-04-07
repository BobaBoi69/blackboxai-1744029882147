package com.example.expensetracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.expensetracker.ui.components.CategoryChip
import com.example.expensetracker.ui.components.GlassCard

@Composable
fun CategorySelectionScreen(
    onBack: () -> Unit,
    onCategorySelected: (String) -> Unit
) {
    val categories = remember {
        listOf(
            CategoryItem("Food", "https://cdn.pexels.com/photo/food-1591777.jpg"),
            CategoryItem("Transport", "https://cdn.pexels.com/photo/transport-1591778.jpg"),
            CategoryItem("Shopping", "https://cdn.pexels.com/photo/shopping-1591779.jpg"),
            CategoryItem("Bills", "https://cdn.pexels.com/photo/bills-1591780.jpg"),
            CategoryItem("Entertainment", "https://cdn.pexels.com/photo/entertainment-1591781.jpg"),
            CategoryItem("Healthcare", "https://cdn.pexels.com/photo/healthcare-1591782.jpg"),
            CategoryItem("Education", "https://cdn.pexels.com/photo/education-1591783.jpg"),
            CategoryItem("Gifts", "https://cdn.pexels.com/photo/gifts-1591784.jpg"),
            CategoryItem("Other", "https://cdn.pexels.com/photo/question-mark-1591785.jpg")
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header with back button
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back"
                )
            }
            Text(
                text = "Select Category",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Categories grid with glassmorphism effect
        GlassCard(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(categories) { category ->
                    CategoryChip(
                        category = category.name,
                        iconUrl = category.iconUrl,
                        onClick = { onCategorySelected(category.name) },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

private data class CategoryItem(
    val name: String,
    val iconUrl: String
)
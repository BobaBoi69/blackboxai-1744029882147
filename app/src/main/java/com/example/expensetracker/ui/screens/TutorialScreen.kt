package com.example.expensetracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.expensetracker.ui.components.GlassCard
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TutorialScreen(
    onBack: () -> Unit,
    onComplete: () -> Unit
) {
    val pagerState = rememberPagerState()
    val tutorials = listOf(
        TutorialPage(
            title = "Track Expenses",
            description = "Easily record your daily expenses by category",
            icon = Icons.Default.ArrowBack // Placeholder - use appropriate icon
        ),
        TutorialPage(
            title = "Manage Budgets",
            description = "Set monthly budgets and track your spending",
            icon = Icons.Default.ArrowBack // Placeholder
        ),
        TutorialPage(
            title = "View Reports",
            description = "Analyze your spending with beautiful charts",
            icon = Icons.Default.ArrowBack // Placeholder
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header
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
                text = "App Tutorial",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Tutorial Pages
        HorizontalPager(
            count = tutorials.size,
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            GlassCard(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = tutorials[page].icon,
                        contentDescription = tutorials[page].title,
                        modifier = Modifier.size(64.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        text = tutorials[page].title,
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = tutorials[page].description,
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        // Page Indicators
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(tutorials.size) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) MaterialTheme.colorScheme.primary
                    else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(8.dp)
                        .clip(MaterialTheme.shapes.small)
                        .background(color)
                )
            }
        }

        // Complete Button
        if (pagerState.currentPage == tutorials.size - 1) {
            Button(
                onClick = onComplete,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color.White
                )
            ) {
                Text("Get Started")
            }
        }
    }
}

private data class TutorialPage(
    val title: String,
    val description: String,
    val icon: ImageVector
)
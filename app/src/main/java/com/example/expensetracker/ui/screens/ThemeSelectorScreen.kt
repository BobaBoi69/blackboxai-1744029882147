package com.example.expensetracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.expensetracker.ui.components.GlassCard
import com.example.expensetracker.ui.theme.AppTheme

@Composable
fun ThemeSelectorScreen(
    onBack: () -> Unit,
    onThemeSelected: (AppTheme) -> Unit
) {
    var selectedTheme by remember { mutableStateOf(AppTheme.SYSTEM) }

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
                text = "App Theme",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Theme Options
        GlassCard(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                AppTheme.values().forEach { theme ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Palette,
                                contentDescription = theme.displayName,
                                modifier = Modifier.size(24.dp),
                                tint = theme.themeColor
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = theme.displayName,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                        RadioButton(
                            selected = selectedTheme == theme,
                            onClick = {
                                selectedTheme = theme
                                onThemeSelected(theme)
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = theme.themeColor
                            )
                        )
                    }
                    if (theme != AppTheme.values().last()) {
                        Divider()
                    }
                }
            }
        }
    }
}
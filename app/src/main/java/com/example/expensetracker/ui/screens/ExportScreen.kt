package com.example.expensetracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Download
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.expensetracker.ui.components.GlassCard

@Composable
fun ExportScreen(
    onBack: () -> Unit,
    onExportCSV: () -> Unit,
    onExportJSON: () -> Unit,
    onExportPDF: () -> Unit
) {
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
                text = "Export Data",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Export Options
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // CSV Export
            GlassCard {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Export as CSV",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        text = "Compatible with spreadsheets",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = onExportCSV,
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = Color.White
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Download,
                            contentDescription = "Export CSV"
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Export CSV")
                    }
                }
            }

            // JSON Export
            GlassCard {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Export as JSON",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        text = "For developers and backups",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = onExportJSON,
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = Color.White
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Download,
                            contentDescription = "Export JSON"
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Export JSON")
                    }
                }
            }

            // PDF Export
            GlassCard {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Export as PDF",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        text = "For printing and sharing",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = onExportPDF,
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = Color.White
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Download,
                            contentDescription = "Export PDF"
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Export PDF")
                    }
                }
            }
        }
    }
}
package com.example.expensetracker.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wallets")
data class Wallet(
    @PrimaryKey val id: String, // Unique identifier
    val name: String,
    val currency: String, // "USD", "EUR", etc.
    val balance: Double
)
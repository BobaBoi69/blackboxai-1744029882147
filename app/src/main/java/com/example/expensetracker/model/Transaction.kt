package com.example.expensetracker.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity(tableName = "transactions")
data class Transaction(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "wallet_id") val walletId: String,
    val amount: Double,
    val type: String, // "income" or "expense"
    val category: String,
    val timestamp: Long,
    val note: String = ""
)
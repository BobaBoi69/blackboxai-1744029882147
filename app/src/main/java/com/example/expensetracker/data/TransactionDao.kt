package com.example.expensetracker.data

import androidx.room.*
import com.example.expensetracker.model.Transaction
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

@Dao
interface TransactionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(transaction: Transaction)

    @Query("SELECT * FROM transactions WHERE wallet_id = :walletId ORDER BY timestamp DESC")
    fun getTransactionsByWallet(walletId: String): Flow<List<Transaction>>

    @Query("""
        SELECT * FROM transactions 
        WHERE wallet_id = :walletId 
        AND timestamp BETWEEN :startDate AND :endDate
        ORDER BY timestamp DESC
    """)
    fun getTransactionsByPeriod(
        walletId: String,
        startDate: Long,
        endDate: Long
    ): Flow<List<Transaction>>

    @Query("""
        SELECT SUM(amount) FROM transactions 
        WHERE wallet_id = :walletId 
        AND type = 'expense'
        AND timestamp BETWEEN :startDate AND :endDate
    """)
    suspend fun getTotalExpenses(walletId: String, startDate: Long, endDate: Long): Double

    @Query("DELETE FROM transactions WHERE id = :transactionId")
    suspend fun deleteTransaction(transactionId: Int)
}
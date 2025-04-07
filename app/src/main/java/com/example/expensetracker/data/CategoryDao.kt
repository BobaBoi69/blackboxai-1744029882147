package com.example.expensetracker.data

import androidx.room.*
import com.example.expensetracker.model.Category
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(category: Category)

    @Query("SELECT * FROM categories")
    fun getAllCategories(): Flow<List<Category>>

    @Query("SELECT * FROM categories WHERE name = :categoryName")
    suspend fun getCategoryByName(categoryName: String): Category?

    @Query("DELETE FROM categories WHERE name = :categoryName")
    suspend fun deleteCategory(categoryName: String)

    @Query("SELECT COUNT(*) FROM categories WHERE name = :categoryName")
    suspend fun categoryExists(categoryName: String): Int
}
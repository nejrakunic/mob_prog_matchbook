package com.example.matchbook.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface LoginDao {
    @Query("SELECT * FROM LoginInfo")
    fun getAll(): Flow<List<LoginInfo>>

    @Query("SELECT * FROM LoginInfo WHERE `E-mail` = :email AND Password = :password")
    suspend fun getUser(email: String, password: String): LoginInfo?

    @Query("SELECT * FROM LoginInfo WHERE `E-mail` = :email")
    suspend fun getUserId(email: String): LoginInfo?

    @Insert
    suspend fun insertUser(loginInfo: LoginInfo)
}
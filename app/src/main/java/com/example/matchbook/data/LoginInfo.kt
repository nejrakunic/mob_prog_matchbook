package com.example.matchbook.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "LoginInfo")
data class LoginInfo(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "Full Name") val fullName: String,
    @ColumnInfo(name = "E-mail") val email: String,
    @ColumnInfo(name = "Password") val password: String,
)


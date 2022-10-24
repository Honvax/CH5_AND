package com.alfrsms.and_ch5.data.user.dao

import androidx.room.*
import com.alfrsms.and_ch5.data.user.entity.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM ACCOUNT_DATABASE WHERE USER_NAME == :userName")
    suspend fun readAccountByUsername(userName: String): UserEntity?

    @Insert
    suspend fun insertAccount(account: UserEntity)

    @Update
    suspend fun updateAccount(account: UserEntity)

    @Delete
    suspend fun deleteAccount(account: UserEntity)
}
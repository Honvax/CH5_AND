package com.alfrsms.and_ch5.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.alfrsms.and_ch5.data.user.dao.UserDao
import com.alfrsms.and_ch5.data.user.entity.UserEntity
import kotlinx.coroutines.launch

class RegisterViewModel (
    val database : UserDao, application: Application) : AndroidViewModel(application) {
    fun insertAccount(account: UserEntity) {
        viewModelScope.launch {
            getDataFromDatabase(account)
        }
    }
    private suspend fun getDataFromDatabase(account: UserEntity) {
        database.insertAccount(account)
    }
}
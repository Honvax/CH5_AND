package com.alfrsms.and_ch5.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.alfrsms.and_ch5.data.user.dao.UserDao
import com.alfrsms.and_ch5.data.user.entity.UserEntity
import kotlinx.coroutines.launch

class LoginViewModel (
    val database : UserDao, application: Application) : AndroidViewModel(application) {
    fun readAccountById(userName: String) : LiveData<UserEntity> {
        val dummy = MutableLiveData <UserEntity>()
        viewModelScope.launch {
            dummy.value = getDataFromDatabase(userName)
        }
        return dummy
    }

    private suspend fun getDataFromDatabase(userName: String) : UserEntity? {
        return database.readAccountByUsername(userName)
    }
}
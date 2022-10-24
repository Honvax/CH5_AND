package com.alfrsms.and_ch5.ui.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alfrsms.and_ch5.data.user.dao.UserDao

class LoginViewModelFactory(
    private val dataSource: UserDao,
    private val application: Application
) : ViewModelProvider.Factory{
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)){
            return LoginViewModel(dataSource, application) as T
        }
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)){
            return RegisterViewModel(dataSource, application) as T
        }
        if (modelClass.isAssignableFrom(ProfileViewModel::class.java)){
            return ProfileViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
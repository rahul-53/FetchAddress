package com.rahul.fetchaddress.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rahul.fetchaddress.repo.MyRepo

class ViewModelFactory (private val mDataSource: MyRepo) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java!!)) {
            return MainViewModel(mDataSource) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
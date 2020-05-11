package com.org.retrofitexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.org.retrofitexample.Models.User
import com.org.retrofitexample.Repositories.MainRepository

class UserViewModel :ViewModel(){
    private val userId: MutableLiveData<String> = MutableLiveData()

    val user : LiveData<User> = Transformations
        .switchMap(userId) {
            MainRepository.getUser(it)
        }

    fun setUserId(userId: String) {
        val update = userId
        if (this.userId.value == update) {
            return
        } else {
            this.userId.value = update
        }
    }

    fun cancelJobs(){
        MainRepository.cancelJobs()
    }
}
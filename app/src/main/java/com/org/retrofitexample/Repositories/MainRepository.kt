package com.org.retrofitexample.Repositories

import androidx.lifecycle.LiveData
import com.org.retrofitexample.APIs.RetrofitBuilder
import com.org.retrofitexample.Models.User
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

object MainRepository {

    var job: CompletableJob? = null

    fun getUser(userId: String) : LiveData<User> {
        job = Job()

        return object: LiveData<User>(){
            override fun onActive() {
                super.onActive()
                job?.let{
                    CoroutineScope(IO + it).launch{
                        val user = RetrofitBuilder.apiService.getUser(userId)
                        withContext(Main) {
                            value = user
                            it.complete()
                        }
                    }
                }
            }
        }
    }

    fun cancelJobs(){
        job?.cancel()
    }
}
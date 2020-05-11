package com.org.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        viewModel.user.observe(this, Observer {
            println("Debug user object ${it}")
        })

        viewModel.setUserId("1")
        println("Debug: ${SingletonUser.singletonUser}")
        println("Debug: ${SingletonUser.singletonUser.hashCode()}")
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.cancelJobs()
    }
}

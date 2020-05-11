package com.org.retrofitexample

import com.org.retrofitexample.Models.User

object SingletonUser {
    val singletonUser: User by lazy {
        User("nikita2302@gmail.com", "Nikita")
    }
}
package ru.itis.summer24.commandproject

import android.app.Application

class App : Application(){
    val mainModule by lazy { MainModule(this) }

    override fun onCreate() {
        super.onCreate()

    }
}
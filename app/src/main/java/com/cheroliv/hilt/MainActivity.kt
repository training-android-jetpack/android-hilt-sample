package com.cheroliv.hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

interface SampleService {
    fun hello(): String
}

class SampleServiceInMemory : SampleService {
    override fun hello(): String = "hello"
}

class SampleViewModel(val sampleService: SampleService) : ViewModel() {
    fun sayHello(activity: AppCompatActivity) {
        Toast.makeText(
            activity,
            sampleService.hello(),
            Toast.LENGTH_SHORT
        ).show()
    }
}

class SampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
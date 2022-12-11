package com.cheroliv.hilt

import android.app.Application
import android.os.Bundle
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel

interface SampleService {
    fun hello(): String
}



class SampleServiceInMemory : SampleService {
    override fun hello(): String = "hello"
}

class SampleViewModel(private val sampleService: SampleService) : ViewModel() {
    fun sayHello(activity: AppCompatActivity) {
        makeText(
            activity,
            sampleService.hello(),
            LENGTH_SHORT
        ).show()
    }
}
//@HiltAndroidApp
class SampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}

class MainActivity : AppCompatActivity() {
    private val sampleService:SampleService=SampleServiceInMemory()
    private val sampleViewModel:SampleViewModel= SampleViewModel(sampleService)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sampleViewModel.sayHello(this)
    }
}
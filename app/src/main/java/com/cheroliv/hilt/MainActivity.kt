package com.cheroliv.hilt

import android.app.Application
import android.os.Bundle
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

interface SampleService {
    fun hello(): String
}


class SampleServiceInMemory : SampleService {
    override fun hello(): String = "hello"
}

//@ViewModelScoped
class SampleViewModel
//@Inject
constructor(
    val sampleService: SampleService
) : ViewModel() {
    fun sayHello(activity: AppCompatActivity) = makeText(
        activity,
        sampleService.hello(),
        LENGTH_SHORT
    ).show()
}

@HiltAndroidApp
class SampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}

//@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
//    @Inject lateinit var sampleService: SampleService
//    @Inject lateinit var sampleViewModel: SampleViewModel
    val sampleService: SampleService = SampleServiceInMemory()
    val sampleViewModel: SampleViewModel = SampleViewModel(sampleService)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sampleViewModel.sayHello(this)
    }
}
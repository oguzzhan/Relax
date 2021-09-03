package com.ozzy.relax.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.ozzy.relax.R
import com.ozzy.relax.data.model.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var dashboardRepository: DashboardRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            dashboardRepository.getDashboard().collect {
                when (it) {
                    is Resource.Error -> {
                        Log.d("getDashboard", "Error")
                    }
                    is Resource.Loading -> {
                        Log.d("getDashboard", "Error")
                    }
                    is Resource.Success -> {
                        Log.d("getDashboard", "Success")
                    }
                }
            }
        }

    }
}
package com.ozzy.relax.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ozzy.relax.R
import com.ozzy.relax.ui.dashboard.DashboardRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var dashboardRepository: DashboardRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
package com.ozzy.relax.ui.dashboard

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ozzy.relax.data.model.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repository: DashboardRepository
) : ViewModel() {

    fun getDashboardData() {
        viewModelScope.launch {
            repository.getDashboard().collect {
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
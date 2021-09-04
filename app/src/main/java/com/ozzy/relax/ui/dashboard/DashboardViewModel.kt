package com.ozzy.relax.ui.dashboard

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ozzy.relax.data.model.Meditation
import com.ozzy.relax.data.model.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repository: DashboardRepository
) : ViewModel() {

    val meditationsLiveData = MutableLiveData<List<Meditation>>()

    init {
        getDashboardData()
    }

    private fun getDashboardData() {
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
                        it.data?.body()?.meditations?.let { meditations ->
                            meditationsLiveData.value = meditations
                        }
                    }
                }
            }
        }
    }
}
package com.ozzy.relax.ui.dashboard

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.ozzy.relax.data.model.Meditation
import com.ozzy.relax.data.model.Resource
import com.ozzy.relax.data.model.Story
import com.ozzy.relax.utils.Event
import com.ozzy.relax.utils.Session
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repository: DashboardRepository
) : ViewModel() {

    val meditationsLiveData = MutableLiveData<List<Meditation>>()
    val storiesLiveData = MutableLiveData<List<Story>>()
    val userName = Session.getInstance()

    val bannerVisibility = MutableLiveData<Boolean>().apply { value = true }
    fun hideClick() {
        bannerVisibility.value = false
    }

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
                        it.data?.body()?.stories?.let { stories ->
                            storiesLiveData.value = stories
                        }
                    }
                }
            }
        }
    }

    val navigationAction = MutableLiveData<Event<NavDirections>>()

    val storyClicked: (Story) -> Unit = {
        val action = DashboardFragmentDirections.actionDashboardFragmentToDetailFragment(story = it)
        navigationAction.value = Event(action)
    }
    val meditationClicked: (Meditation) -> Unit = {
        val action =
            DashboardFragmentDirections.actionDashboardFragmentToDetailFragment(meditation = it)
        navigationAction.value = Event(action)
    }
}
package com.ozzy.relax.ui.dashboard.adapter.stories

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ozzy.relax.data.model.Story

/**
 * Created by Oğuzhan Karacan on 4.09.2021.
 */
@BindingAdapter("app:storyList", "app:storyClick")
fun setStoryList(recyclerView: RecyclerView, list: List<Story>?, onClick: ((Story) -> Unit)?) {
    if (recyclerView.adapter == null) {
        recyclerView.adapter = StoriesAdapter(onClick)
    }

    (recyclerView.adapter as StoriesAdapter).submitList(list)
}
package com.ozzy.relax.ui.dashboard.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ozzy.relax.data.model.Meditation

/**
 * Created by Oğuzhan Karacan on 4.09.2021.
 */
@BindingAdapter("app:meditationsList")
fun setMeditationList(recyclerView: RecyclerView, list: List<Meditation>?) {
    if (recyclerView.adapter == null) {
        recyclerView.adapter = MeditationsAdapter()
    }

    (recyclerView.adapter as MeditationsAdapter).submitList(list)
}
package com.ozzy.relax.ui.dashboard.adapter.meditations

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ozzy.relax.data.model.Meditation

/**
 * Created by Oğuzhan Karacan on 4.09.2021.
 */
@BindingAdapter("app:meditationsList", "app:meditationClick")
fun setMeditationList(
    recyclerView: RecyclerView,
    list: List<Meditation>?,
    onClick: ((Meditation) -> Unit)?
) {
    if (recyclerView.adapter == null) {
        recyclerView.adapter = MeditationsAdapter(onClick)
    }

    (recyclerView.adapter as MeditationsAdapter).submitList(list)
}
package com.ozzy.relax.ui.dashboard.adapter.meditations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ozzy.relax.data.model.Meditation
import com.ozzy.relax.databinding.ItemMeditationsBinding

/**
 * Created by Oğuzhan Karacan on 4.09.2021.
 */
class MeditationsAdapter(private val onClick: ((Meditation) -> Unit)?) :
    ListAdapter<Meditation, MeditationsAdapter.MeditationsViewHolder>(
        DIFF_CALLBACK
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeditationsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMeditationsBinding.inflate(inflater, parent, false)
        return MeditationsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MeditationsViewHolder, position: Int) {
        holder.bindData(getItem(position))
        holder.setOnClickListener(getItem(position))
    }


    inner class MeditationsViewHolder(private val binding: ItemMeditationsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: Meditation) {
            binding.item = item
        }

        fun setOnClickListener(item: Meditation) {
            binding.root.setOnClickListener {
                onClick?.invoke(item)
            }
        }
    }
}

val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Meditation>() {
    override fun areItemsTheSame(oldItem: Meditation, newItem: Meditation): Boolean {
        return oldItem.content == newItem.content &&
                oldItem.image == newItem.image &&
                oldItem.releaseDate == newItem.releaseDate &&
                oldItem.subtitle == newItem.subtitle &&
                oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Meditation, newItem: Meditation): Boolean {
        return oldItem == newItem
    }

}

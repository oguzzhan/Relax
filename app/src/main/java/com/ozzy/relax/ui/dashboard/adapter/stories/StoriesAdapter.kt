package com.ozzy.relax.ui.dashboard.adapter.stories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ozzy.relax.data.model.Story
import com.ozzy.relax.databinding.ItemStoriesBinding
import com.ozzy.relax.ui.dashboard.adapter.stories.StoriesAdapter.StoryViewHolder

/**
 * Created by Oğuzhan Karacan on 4.09.2021.
 */
class StoriesAdapter(private val onClick: ((Story) -> Unit)?) : ListAdapter<Story, StoryViewHolder>(
    DIFF_CALLBACK
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemStoriesBinding.inflate(inflater, parent, false)
        return StoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        holder.bindData(getItem(position))
        holder.setOnClickListener(getItem(position))
    }


    inner class StoryViewHolder(private val binding: ItemStoriesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: Story) {
            binding.item = item
        }

        fun setOnClickListener(item: Story) {
            binding.root.setOnClickListener {
                onClick?.invoke(item)
            }
        }
    }
}

val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Story>() {
    override fun areItemsTheSame(oldItem: Story, newItem: Story): Boolean {
        return oldItem.text == newItem.text &&
                oldItem.image == newItem.image &&
                oldItem.category == newItem.category &&
                oldItem.date == newItem.date
    }

    override fun areContentsTheSame(oldItem: Story, newItem: Story): Boolean {
        return oldItem == newItem
    }

}

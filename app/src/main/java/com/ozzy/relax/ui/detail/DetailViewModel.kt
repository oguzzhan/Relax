package com.ozzy.relax.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ozzy.relax.data.model.Meditation
import com.ozzy.relax.data.model.Story
import com.ozzy.relax.utils.extension.getDate

class DetailViewModel : ViewModel() {

    val item = MutableLiveData<DetailItem>()


    fun setItem(meditation: Meditation?, story: Story?) {
        val detailItem = DetailItem()
        if (meditation != null) {
            detailItem.detailType = DetailType.MEDITATION
            detailItem.itemTitle = meditation.title
            detailItem.itemDesc = meditation.content
            detailItem.date = meditation.releaseDate?.getDate()
            detailItem.image = meditation.image?.large
        } else if (story != null) {
            detailItem.detailType = DetailType.STORY
            detailItem.itemTitle = story.name
            detailItem.itemDesc = story.text
            detailItem.date = story.date?.getDate()
            detailItem.image = story.image?.large
        }
        item.value = detailItem
    }
}

enum class DetailType {
    STORY, MEDITATION
}

data class DetailItem(
    var detailType: DetailType? = null,
    var itemTitle: String? = "",
    var itemDesc: String? = "",
    var date: String? = "",
    var image: String? = ""
)
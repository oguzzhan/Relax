package com.ozzy.relax.ui.detail

import android.media.MediaPlayer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ozzy.relax.data.model.Meditation
import com.ozzy.relax.data.model.Story
import com.ozzy.relax.utils.extension.getDate


class DetailViewModel : ViewModel() {

    val item = MutableLiveData<DetailItem>()
    val playButton = MutableLiveData<Boolean>().apply { value = false }

    val AUDIO_PATH = "https://d2r0ihkco3hemf.cloudfront.net/bgxupraW2spUpr_y2.mp3"
    private var mediaPlayer: MediaPlayer? = null

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

    fun onPlayClick() {
        if (mediaPlayer == null || mediaPlayer?.isPlaying != true) {
            playAudio()
        } else {
            stopAudio()
        }
    }


    private fun playAudio() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer()
            mediaPlayer?.setDataSource(AUDIO_PATH)
            mediaPlayer?.prepare()
        }
        mediaPlayer?.start()
        playButton.value = true
    }

    private fun stopAudio() {
        if (mediaPlayer?.isPlaying == true) {
            playButton.value = false
            mediaPlayer?.pause()
        }
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
package com.ozzy.relax.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.google.android.material.appbar.MaterialToolbar
import com.ozzy.relax.R
import com.ozzy.relax.ui.detail.DetailType
import com.squareup.picasso.Picasso

/**
 * Created by Oğuzhan Karacan on 4.09.2021.
 */
@BindingAdapter("android:visibility")
fun visibility(view: View, visibility: Boolean) {
    view.isVisible = visibility
}

@BindingAdapter("android:src")
fun setImage(imageView: ImageView, imageUrl: String?) {
    imageUrl?.let {
        Picasso.get().load(it).into(imageView)
    }
}

@BindingAdapter("android:bannerText")
fun setBannerText(textView: TextView, text: String?) {
    val textWithName = textView.context.getString(R.string.banner_text, text ?: "")
    textView.text = textWithName
}

@BindingAdapter("android:setToolbarTitle")
fun setToolbarTitle(materialToolbar: MaterialToolbar, detailType: DetailType?) {
    when (detailType) {
        DetailType.STORY -> {
            materialToolbar.setTitle(R.string.detail_page_story_title)
        }
        DetailType.MEDITATION -> {
            materialToolbar.setTitle(R.string.detail_page_meditation_title)
        }
        null -> {
            materialToolbar.setTitle(R.string.detail_page_title)
        }
    }
}
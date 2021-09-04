package com.ozzy.relax.utils

import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
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
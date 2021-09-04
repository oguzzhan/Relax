package com.ozzy.relax.utils.extension

import android.app.Activity
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat

/**
 * Created by Oğuzhan Karacan on 4.09.2021.
 */

fun Activity.backGroundColorDrawable(drawable: Drawable) {
    window.statusBarColor =
        ContextCompat.getColor(this, android.R.color.transparent)
    window.statusBarColor = ContextCompat.getColor(this, android.R.color.transparent)
    window.setBackgroundDrawable(drawable)
}

fun Activity.backGroundColor(color: Int) {
    window.statusBarColor =
        ContextCompat.getColor(this, android.R.color.transparent)
    window.statusBarColor = ContextCompat.getColor(this, color)
}
package com.ozzy.relax.utils

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

/**
 * Created by Oğuzhan Karacan on 4.09.2021.
 */
@BindingAdapter("android:visibility")
fun visibility(view: View, visibility: Boolean) {
    view.isVisible = visibility
}
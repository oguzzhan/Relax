package com.ozzy.relax.utils.extension

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Oğuzhan Karacan on 5.09.2021.
 */
fun String.getDate(): String {
    val sdf = SimpleDateFormat("MM/dd/yyyy, E", Locale.ENGLISH)
    val millis = this.toLong()
    val date = Date(millis * 1000)
    return sdf.format(date)
}
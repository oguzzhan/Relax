package com.ozzy.relax.utils

/**
 * Created by Oğuzhan Karacan on 4.09.2021.
 */
object Session {
    private var userName: String? = null

    fun getInstance() = userName ?: ""

    fun setInstance(userName: String) {
        this.userName = userName
    }
}
package com.ozzy.relax.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class DashboardResponse(
    @SerializedName("isBannerEnabled")
    val isBannerEnabled: Boolean? = null,
    @SerializedName("meditations")
    val meditations: List<Meditation>? = null,
    @SerializedName("stories")
    val stories: List<Story>? = null
)

@Parcelize
data class Meditation(
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("subtitle")
    val subtitle: String? = null,
    @SerializedName("image")
    val image: Image? = null,
    @SerializedName("releaseDate")
    val releaseDate: String? = null,
    @SerializedName("content")
    val content: String? = null
) : Parcelable

@Parcelize
data class Story(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("category")
    val category: String? = null,
    @SerializedName("image")
    val image: Image? = null,
    @SerializedName("date")
    val date: String? = null,
    @SerializedName("text")
    val text: String? = null
) : Parcelable

@Parcelize
data class Image(
    @SerializedName("small")
    val small: String? = null,
    @SerializedName("large")
    val large: String? = null
) : Parcelable
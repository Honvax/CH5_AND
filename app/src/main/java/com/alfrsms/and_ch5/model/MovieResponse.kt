package com.alfrsms.and_ch5.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Suppress("DEPRECATED_ANNOTATION")
@Parcelize
data class MovieResponse(
    @SerializedName("results")
    val movies : List<Data>
) : Parcelable {
    constructor() : this(mutableListOf())
}
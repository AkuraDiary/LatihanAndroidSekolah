package com.smktelkommlg.movieproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SearchItem(
    val type: String? = null,
    val year: String? = null,
    val imdbID: String? = null,
    val poster: String? = null,
    val title: String? = null
) : Parcelable
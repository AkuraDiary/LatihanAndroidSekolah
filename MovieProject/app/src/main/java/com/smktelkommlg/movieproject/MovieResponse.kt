package com.smktelkommlg.movieproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class MovieResponse(
    val response: String? = null,
    val totalResults: String? = null,
    val search: List<SearchItem>? = null
) : Parcelable
package com.smktelkommlg.movieproject

@Parcelize
data class MovieResponse(
	val response: String? = null,
	val totalResults: String? = null,
	val search: List<SearchItem?>? = null
) : Parcelable

@Parcelize
data class SearchItem(
	val type: String? = null,
	val year: String? = null,
	val imdbID: String? = null,
	val poster: String? = null,
	val title: String? = null
) : Parcelable


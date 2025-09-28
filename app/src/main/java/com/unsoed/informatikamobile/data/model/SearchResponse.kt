package com.unsoed.informatikamobile.data.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("docs")
    val docs: List<BookDoc> = emptyList()
)

data class BookDoc(
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("author_name")
    val authorName: List<String>? = null,
    @SerializedName("first_publish_year")
    val firstPublishYear: Int? = null
)

package com.admiral26.movieappmvvmauth.data.model.home.header


import com.admiral26.movieappmvvmauth.data.model.BaseModel
import com.google.gson.annotations.SerializedName

data class HeaderRespons(
    @SerializedName("dates")
    val dates: Dates,
    @SerializedName("page")
    val page: Int, // 1
    @SerializedName("results")
    val resultHeads: List<ResultHead>,
    @SerializedName("total_pages")
    val totalPages: Int, // 177
    @SerializedName("total_results")
    val totalResults: Int // 3540
): BaseModel() {
    override fun getType(): Int {
        return TOP_HEAD_LINE
    }
}
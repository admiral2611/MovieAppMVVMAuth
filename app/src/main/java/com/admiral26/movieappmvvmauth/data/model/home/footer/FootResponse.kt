package com.admiral26.movieappmvvmauth.data.model.home.footer


import com.admiral26.movieappmvvmauth.data.model.BaseModel
import com.google.gson.annotations.SerializedName

data class FootResponse(
    @SerializedName("page")
    val page: Int, // 1
    @SerializedName("results")
    val resultFoots: List<ResultFoot>,
    @SerializedName("total_pages")
    val totalPages: Int, // 42636
    @SerializedName("total_results")
    val totalResults: Int // 852709
): BaseModel() {
    override fun getType(): Int {
        return FOOT_LINE
    }
}
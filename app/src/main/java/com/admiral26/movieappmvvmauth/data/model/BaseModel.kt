package com.admiral26.movieappmvvmauth.data.model

abstract class BaseModel {
    companion object{
        const val TOP_HEAD_LINE = 0
        const val FOOT_LINE = 1
    }

    abstract fun getType() :Int
}
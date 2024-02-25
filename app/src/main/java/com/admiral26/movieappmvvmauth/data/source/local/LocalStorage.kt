package com.admiral26.movieappmvvmauth.data.source.local

import android.content.Context
import com.admiral26.movieappmvvmauth.util.helpers.BooleanPreference
import com.admiral26.movieappmvvmauth.util.helpers.StringPreference
import com.securepreferences.SecurePreferences
import javax.inject.Singleton

@Singleton
class LocalStorage (context: Context) {
    private val KEY = "djfsiojfOJO[FJIOSAFJOAWHFOFHIOSADFHEIWUOFJIOFJFWEFJWIEFJOWHF"
    private val securePref = SecurePreferences(context,KEY,"local_security.xml")

    var isFirst:Boolean by BooleanPreference(securePref,true)
    var sessionId:String by StringPreference(securePref,"")
}
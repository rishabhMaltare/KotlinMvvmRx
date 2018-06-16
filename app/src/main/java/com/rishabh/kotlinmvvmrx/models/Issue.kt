package com.rishabh.kotlinmvvmrx.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Issue {

    @SerializedName("href")
    @Expose
    var href: String? = null

}

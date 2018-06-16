package com.rishabh.kotlinmvvmrx.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Base {

    @SerializedName("label")
    @Expose
    var label: String? = null

    @SerializedName("ref")
    @Expose
    var ref: String? = null

    @SerializedName("sha")
    @Expose
    var sha: String? = null

}

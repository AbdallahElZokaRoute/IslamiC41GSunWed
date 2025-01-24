package com.route.islamiappc41gsunwed.home.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Chapter(
    val order: Int? = null,
    val titleAr: String? = null,
    val titleEn: String? = null,
    val length: String? = null
) : Parcelable

package com.example.jetpack_navigation

import java.math.BigDecimal
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class Money(val amount : BigDecimal) : Parcelable{


}


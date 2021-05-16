package com.sudopk.kandroid

import androidx.annotation.StringRes

interface StrFromRes {
    fun getString(@StringRes resId: Int): String

    fun getString(@StringRes resId: Int, vararg formatArgs: Any): String
}
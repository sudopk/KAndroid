package com.sudopk.kandroid

import android.content.Context

private class StrFromResImpl(val context: Context) : StrFromRes {
    override fun getString(resId: Int): String {
        return context.getString(resId)
    }

    override fun getString(resId: Int, vararg formatArgs: Any): String {
        return context.getString(resId, formatArgs)
    }
}

val Context.strFromRes: StrFromRes
    get() = StrFromResImpl(applicationContext)



package com.sudopk.kandroid

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity

fun Fragment.application(): Application {
    return activity!!.application
}

val Fragment.appCompatActivity
    get() = activity as AppCompatActivity

inline fun <reified T> Fragment.parent() = (parentFragment ?: activity) as T

inline fun Fragment.ifResumed(block: () -> Unit) {
    if (isResumed) {
        block()
    }
}
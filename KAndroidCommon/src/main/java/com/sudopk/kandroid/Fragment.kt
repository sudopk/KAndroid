package com.sudopk.kandroid

import android.app.Application
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

fun android.app.Fragment.application(): Application {
    return activity.application
}

fun Fragment.application(): Application {
    return activity.application
}

val Fragment.appCompatActivity
    get() = activity as AppCompatActivity

inline fun <reified T> Fragment.parent() = (parentFragment ?: activity) as T

inline fun Fragment.ifResumed(block: ()-> Unit) {
    if(isResumed) {
        block()
    }
}
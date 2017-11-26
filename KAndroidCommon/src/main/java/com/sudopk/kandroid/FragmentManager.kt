package com.sudopk.kandroid

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import kotlin.reflect.KClass


fun FragmentManager.replace(@IdRes containerId: Int, fragment: Fragment) {
    beginTransaction()
            .replace(containerId, fragment)
            .commit()
}

fun FragmentManager.notFoundByTag(tag: String, block: (tag: String) -> Unit) {
    executePendingTransactions()
    if (findFragmentByTag(tag).isNull()) {
        block(tag)
    }
}

fun FragmentManager.foundByTag(tag: String, block: (fragment: Fragment) -> Unit) {
    executePendingTransactions()
    val fragment = findFragmentByTag(tag)
    if (fragment.isNotNull()) {
        block(fragment)
    }
}

fun FragmentManager.notFoundById(@IdRes id: Int, fragmentClass: KClass<out Fragment>,
                                 block: (id: Int) -> Unit) {
    executePendingTransactions()
    val fragment = findFragmentById(id)
    if (fragment.isNull() || fragment::class != fragmentClass) {
        block(id)
    }
}

fun FragmentManager.foundById(@IdRes id: Int, fragmentClass: KClass<out Fragment>,
                              block: (fragment: Fragment) -> Unit) {
    executePendingTransactions()
    val fragment = findFragmentById(id)
    if (fragment.isNotNull() || fragment::class == fragmentClass) {
        block(fragment)
    }
}


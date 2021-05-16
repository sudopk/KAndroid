package com.sudopk.kandroid

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlin.reflect.KClass


fun FragmentManager.replace(@IdRes containerId: Int, fragment: Fragment) {
    beginTransaction()
            .replace(containerId, fragment)
            .commit()
}

inline fun FragmentManager.notFoundByTag(tag: String, block: (tag: String) -> Unit) {
    executePendingTransactions()
    if (findFragmentByTag(tag) == null) {
        block(tag)
    }
}

inline fun FragmentManager.foundByTag(tag: String, block: (fragment: Fragment) -> Unit) {
    executePendingTransactions()
    findFragmentByTag(tag)?.let(block)
}

inline fun <reified T: Fragment> FragmentManager.notFoundById(@IdRes id: Int,
                                                                                                                                                block: (id: Int) -> Unit) {
    executePendingTransactions()
    val fragment = findFragmentById(id)
    if (fragment == null || fragment::class != T::class) {
        block(id)
    }
}

 inline fun <reified T: Fragment> FragmentManager.foundById(@IdRes id: Int,
                                                                                                                                              block: (fragment: T) -> Unit) {
    executePendingTransactions()
    val fragment = findFragmentById(id)
    if (fragment != null && fragment::class == T::class) {
        block(fragment as T)
    }
}


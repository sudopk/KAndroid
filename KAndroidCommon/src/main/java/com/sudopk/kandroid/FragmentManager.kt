package com.sudopk.kandroid

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager


fun FragmentManager.replace(@IdRes containerId: Int, fragment: Fragment) {
    beginTransaction()
            .replace(containerId, fragment)
            .commit()
}
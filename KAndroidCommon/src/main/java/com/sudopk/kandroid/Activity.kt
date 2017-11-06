package com.sudopk.kandroid

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

fun AppCompatActivity.hasFragmentByTag(tag: String?) = supportFragmentManager.findFragmentByTag(tag).isNotNull()

fun Fragment.hasFragmentByTag(tag: String?) = childFragmentManager.findFragmentByTag(tag).isNotNull()



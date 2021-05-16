package com.sudopk.kandroid

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.hasFragmentByTag(tag: String?) =
  supportFragmentManager.findFragmentByTag(tag) != null

fun Fragment.hasFragmentByTag(tag: String?) = childFragmentManager.findFragmentByTag(tag) != null



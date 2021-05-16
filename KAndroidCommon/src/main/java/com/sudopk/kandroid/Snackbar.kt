package com.sudopk.kandroid

import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar
import android.view.View

fun View.snackbar(msg: String) {
    Snackbar.make(this, msg, Snackbar.LENGTH_SHORT).show()
}

fun View.snackbar(@StringRes msg: Int) {
    Snackbar.make(this, msg, Snackbar.LENGTH_SHORT).show()
}

fun View.snackbarLong(msg: String) {
    Snackbar.make(this, msg, Snackbar.LENGTH_LONG).show()
}

fun View.snackbarLong(@StringRes msg: Int) {
    Snackbar.make(this, msg, Snackbar.LENGTH_LONG).show()
}

fun View.snackbarIndefinite(msg: String) {
    Snackbar.make(this, msg, Snackbar.LENGTH_INDEFINITE).show()
}

fun View.snackbarIndefinite(@StringRes msg: Int) {
    Snackbar.make(this, msg, Snackbar.LENGTH_INDEFINITE).show()
}
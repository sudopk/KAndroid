package com.sudopk.kandroid

import org.jetbrains.anko.*

object Logger : AnkoLogger {
    fun Any.logv(message: String) {
        verbose(message)
    }

    fun Any.logd(message: String) {
        debug(message)
    }

    fun Any.logi(message: String) {
        info(message)
    }

    fun Any.logw(message: String) {
        warn(message)
    }

    fun Any.loge(message: String) {
        error(message)
    }

    fun Any.logf(message: String) {
        wtf(message)
    }
}
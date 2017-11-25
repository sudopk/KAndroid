package com.sudopk.kandroid

fun Any.logv(message: String) {
    logv(javaClass.simpleName, message)
}

fun Any.logd(message: String) {
    logd(javaClass.simpleName, message)
}

fun Any.logi(message: String) {
    logi(javaClass.simpleName, message)
}

fun Any.logw(message: String) {
    logw(javaClass.simpleName, message)
}

fun Any.loge(message: String) {
    loge(javaClass.simpleName, message)
}

fun Any.logf(message: String) {
    logf(javaClass.simpleName, message)
}
package com.sudopk.kandroid

import java.util.*

fun Calendar.isToday() = sameDay(Calendar.getInstance())

fun Calendar.sameDay(calendar: Calendar): Boolean {
    return calendar.get(Calendar.YEAR) == get(Calendar.YEAR) &&
            calendar.get(Calendar.MONTH) == get(Calendar.MONTH) &&
            calendar.get(Calendar.DATE) == get(Calendar.DATE)
}
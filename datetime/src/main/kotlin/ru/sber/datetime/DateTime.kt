package ru.sber.datetime

import java.time.*
import java.time.format.DateTimeFormatter
import java.util.*

// 1.
fun getZonesWithNonDivisibleByHourOffset(): Set<String> {
    val timezoneList = ZoneId.getAvailableZoneIds()
    val ansList = mutableSetOf<String>()
    for (i in timezoneList) {
        val value = LocalDateTime.now().atZone(ZoneId.of(i)).offset
        if (value.totalSeconds % 3600 != 0)
            ansList.add(i)
    }
    return ansList
}

// 2.
fun getLastInMonthDayWeekList(year: Int): List<String> {
    val ansList = mutableListOf<String>()
    for (i in 1..12) {
        ansList.add(YearMonth.of(year, Month.of(i)).atEndOfMonth().dayOfWeek.name)
    }
    return ansList
}

// 3.
fun getNumberOfFridayThirteensInYear(year: Int): Int {
    var ans = 0
    for (i in 1..12) {
        if (YearMonth.of(year, Month.of(i)).atDay(13).dayOfWeek.name == DayOfWeek.FRIDAY.toString())
            ans++
    }
    return ans
}

// 4.
fun getFormattedDateTime(dateTime: LocalDateTime): String {
    return DateTimeFormatter.ofPattern("dd MMM YYYY, HH:mm", Locale.US).format(dateTime)
}

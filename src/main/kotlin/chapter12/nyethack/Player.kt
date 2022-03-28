package chapter12.nyethack

import java.util.*

class Player {
    var name = "madrigal"
        get() = field.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }   // capitalize() is deprecated
        private set(value) {
            field = value.trim()
        }

    var healthPoints = 89
    val blessed = true
    private val immortal = false

    fun castFireball(numFireballs: Int = 2) = println("한 덩어리의 Fire Ball이 나타난다. (x$numFireballs)")

    fun auraColor(): String =
        if (blessed && healthPoints > 50 || immortal) {
            "GREEN"
        } else {
            "NONE"
        }

    fun formatHealthStatus(): String = when (healthPoints) {
        100 -> "최상의 상태임!"
        in 90..99 -> "약간의 찰과상이 있음!"
        in 75..89 -> if (blessed) "경미한 상처가 있지만 빨리 치유됨." else "경미한 상처만 있음!"
        in 15..74 -> "많이 다친 것 같음!"
        else -> "최악의 상태임!"
    }
}
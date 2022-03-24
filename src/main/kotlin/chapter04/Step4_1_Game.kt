package chapter04

import kotlin.math.pow

fun main(vararg arg: String) {
    val name: String = "마드리갈"
    var healthPoints: Int = 89
    healthPoints += 3

    var isBlessed = true
    val isImmortal = false
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal

    val healthStatus = formatHealthStatus(healthPoints, isBlessed)
    val auraColor = if (auraVisible) getAuraColor(healthPoints) else "NONE"

    val statusFormatString = "(HP: $healthPoints)(Aura: $auraColor)(Blessed: ${if (isBlessed) "YES" else "NO"} -> $name $healthStatus"
    println(statusFormatString)
}

private fun getAuraColor(healthPoints: Int) = when ((Math.random().pow((110 - healthPoints) / 100.0) * 20).toInt()) {
    in 0..5 -> "RED"
    in 6..10 -> "ORANGE"
    in 11..15 -> "PURPLE"
    in 16..20 -> "GREEN"
    else -> "NONE"
}

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String = when (healthPoints) {
    100 -> "최상의 상태임!"
    in 90..99 -> "약간의 찰과상이 있음!"
    in 75..89 -> if (isBlessed) "경미한 상처가 있지만 빨리 치유됨." else "경미한 상처만 있음!"
    in 15..74 -> "많이 다친 것 같음!"
    else -> "최악의 상태임!"
}
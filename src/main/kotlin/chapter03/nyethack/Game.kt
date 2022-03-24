package chapter03.nyethack

import kotlin.math.pow

fun getAuraColor(healthPoints: Int) = when ((Math.random().pow((110 - healthPoints) / 100.0) * 20).toInt()) {
    in 0..5 -> "RED"
    in 6..10 -> "ORANGE"
    in 11..15 -> "PURPLE"
    in 16..20 -> "GREEN"
    else -> "NONE"
}

fun main(vararg args: String) {
    val name = "마드리갈"
    // var healthPoints = 100
    var healthPoints = 100
    val isBlessed = true
    val isImmortal = false

    // Aura
    // if (isBlessed && healthPoints > 50 || isImmortal) {
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal

    /*if (auraVisible) {
        println("GREEN")
    } else {
        println("NONE")
    }*/

    val auraColor = if (auraVisible) getAuraColor(healthPoints) else "NONE"

    /*val auraColor = if (auraVisible) "GREEN" else "NONE"
    println(auraColor)*/

    // health status
    val healthStatus = when (healthPoints) {
        100 -> "최상의 상태임!"
        in 90..99 -> "약간의 찰과상이 있음!"
        in 75..89 -> if (isBlessed) "경미한 상처가 있지만 빨리 치유됨." else "경미한 상처만 있음!"
        in 15..74 -> "많이 다친 것 같음!"
        else -> "최악의 상태임!"
    }
    /*val healthStatus = if (healthPoints == 100) {
        "최상의 상태임!"
        // } else if (healthPoints >= 90) {
    } else if (healthPoints in 90..99) {
        "약간의 찰과상이 있음!"
        // } else if (healthPoints >= 75) {
    } else if (healthPoints in 75..89) {
        if (isBlessed) {
            "경미한 상처가 있지만 빨리 치유됨."
        } else {
            "경미한 상처만 있음!"
        }
    // } else if (healthPoints >= 15) {
    } else if (healthPoints in 15..74) {
        "많이 다친 것 같음!"
    } else {
        "최악의 상태임!"
    }*/

    /*println("(Aura: $auraColor) (Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")*/

    val statusFormatString = "(HP: $healthPoints)(Aura: $auraColor) -> $healthStatus"
    println(statusFormatString)

    /*if (healthPoints == 100) {
        println(name + " 최상의 상태임!")
    } else if (healthPoints >= 90) {
        println(name + " 약간의 찰과상이 있음!")
    } else if (healthPoints >= 75) {
        if (isBlessed) {
            println(name + " 경미한 상처가 있지만 빨리 치유됨.")
        } else {
            println(name + " 경미한 상처만 있음!")
        }
    } else if (healthPoints >= 15) {
        println(name + " 많이 다친 것 같음!")
    } else {
        println(name + " 최악의 상태임!")
    }*/

    // arrows in quiver
    var arrowsInQuiver = 2
    if (arrowsInQuiver >= 5) {
        println("화살이 충분함")
        println("더 이상의 화살을 가질 수 없음")
    }
}
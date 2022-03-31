package chapter15.nyethack

import java.io.File
import java.util.*

class Player(
    _name: String,
    var healthPoints: Int = 100,
    val blessed: Boolean,
    private val immortal: Boolean
) {

    constructor(name: String) : this(
        _name = name,
        // healthPoints = 100,
        blessed = true,
        immortal = false
    ) {
        if (name.lowercase(Locale.getDefault()) == "kar") healthPoints = 40
    }

    var name = _name
        // get() = field.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }   // capitalize() is deprecated
        get() = "${field.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }} of $hometown"
        private set(value) {
            field = value.trim()
        }

    // val hometown: String = selectHomeTown()
    val hometown by lazy { selectHomeTown() }
    var currentPosition = Coordinate(0, 0)

    init {
        require(healthPoints > 0) { "healthPoints는 0보다 커야 합니다." }
        require(name.isNotBlank()) { "플레이어는 이름이 있어야 합니다." }
    }

    private fun selectHomeTown() = File(Player::class.java.classLoader.getResource("data/towns.txt")!!.toURI())
        .readText()
        .split("\r\n")
        .shuffled()
        .first()

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
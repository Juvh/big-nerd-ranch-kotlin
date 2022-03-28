package chapter11

import ForFileTempClass
import java.io.File
import kotlin.math.roundToInt

private var playerGold = 10
private var playerSilver = 10
private val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
private val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
private val uniquePatrons = mutableSetOf<String>()
private val menuList = File(ForFileTempClass::class.java.classLoader.getResource("data/tavern-menu-data.txt")!!.toURI())
    .readText()
    .split("\r\n")
private var patronGold = mapOf(
    "Eli" to 10.5,
    "Mordoc" to 8.0,
    "Sophie" to 5.5
)

private const val TAVERN_NAME = "Taernyl's Folly"

fun main(args: Array<String>) {
    repeat((0..9).count()) {
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons += name
    }

    println(uniquePatrons)

    var orderCount = 0
    while (orderCount <= 9) {
        placeOrder(uniquePatrons.shuffled().first(), menuList.shuffled().first())
        orderCount++
    }

    println(patronGold)
    println(patronGold["Eli"])
    println(patronGold["Mordoc"])
    println(patronGold["Sophie"])
}

private fun performPurchase(price: Double) {
    displayBalance()

    val totalPurse = playerGold + (playerGold / 100.0)
    println("지갑 전체 금액: 금화: $totalPurse")

    println("금화 $price 로 술을 구입함.")

    val remainingBalance = totalPurse - price
    println("남은 잔액: ${"%.2f".format(remainingBalance)}")

    playerGold = remainingBalance.toInt()
    playerSilver = (remainingBalance % 1 * 100).roundToInt()
    displayBalance()
}

private fun displayBalance() {
    println("플레이어의 지갑 잔액: 금화: $playerGold 개, 은화: $playerSilver 개")
}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }


private fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName 은 $tavernMaster 에게 주문한다.")

    val (type, name, price) = menuData.split(",")
    println("$patronName 은 금화 $price 로 $name ($type)를 구입한다.")

    performPurchase(price.toDouble())

    val phrase = if (name == "Dragon's Breath") {
        "$patronName 이 감탄한다: ${toDragonSpeak("와, $name 진짜 좋구나!")}"
    } else {
        "$patronName 이 말한다: 감사합니다 $name"
    }

    println(phrase)
}
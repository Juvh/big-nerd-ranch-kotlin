package chapter11

import ForFileTempClass
import java.io.File

private val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
private val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
private val uniquePatrons = mutableSetOf<String>()
private val menuList = File(ForFileTempClass::class.java.classLoader.getResource("data/tavern-menu-data.txt")!!.toURI())
    .readText()
    .split("\r\n")

private val patronGold = mutableMapOf<String, Double>()

private const val TAVERN_NAME = "Taernyl's Folly"

fun main(args: Array<String>) {
    repeat((0..9).count()) {
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons += name
    }

    uniquePatrons.forEach {
        patronGold[it] = 6.0
    }

    var orderCount = 0
    while (orderCount <= 9 && uniquePatrons.isNotEmpty()) { // uniquePatron 의 수가 줄어들기 때문에 isNotEmpty 조건을 추가한다.
        placeOrder(uniquePatrons.shuffled().first(), menuList.shuffled().first())
        orderCount++
    }

    displayPatronBalance()
}

private fun displayPatronBalance() {
    patronGold.forEach { (patron, balance) ->
        println("$patron, balance: ${"%.2f".format(balance)}")
    }
}

private fun performPurchase(price: Double, patronName: String) {
    val totalPurse = patronGold.getValue(patronName)

    if (totalPurse < price) {
        // 잔액이 부족하면 야속하게 명단에서 제거한다.
        uniquePatrons.remove(patronName)
        patronGold.remove(patronName)
    } else {
        patronGold[patronName] = totalPurse - price
    }
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

    performPurchase(price.toDouble(), patronName)

    val phrase = if (name == "Dragon's Breath") {
        "$patronName 이 감탄한다: ${toDragonSpeak("와, $name 진짜 좋구나!")}"
    } else {
        "$patronName 이 말한다: 감사합니다 $name"
    }

    println(phrase)
}
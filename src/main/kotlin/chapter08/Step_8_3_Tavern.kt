package chapter08

// Int to Double
// Double type formatting

private var playerGold = 10
private var playerSilver = 10

private const val TAVERN_NAME = "Taernyl's Folly"

fun main(args: Array<String>) {
    placeOrder("shandy,Dragon's Breath,5.91")
}

private fun performPurchase(price: Double) {
    displayBalance()

    val totalPurse = playerGold + (playerGold / 100.0)
    println("지갑 전체 금액: 금화: $totalPurse")

    println("금화 $price 로 술을 구입함.")

    val remainingBalance = totalPurse - price
    println("남은 잔액: ${"%.2f".format(remainingBalance)}")
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


private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("마드리갈은 $tavernMaster 에게 주문한다.")

    val (type, name, price) = menuData.split(",")
    println("마드리갈은 금화 $price 로 $name ($type)를 구입한다.")

    performPurchase(price.toDouble())

    val phrase = if (name == "Dragon's Breath") {
        "마드리드갈이 감탄한다: ${toDragonSpeak("와, $name 진짜 좋구나!")}"
    } else {
        "마드리갈이 말한다: 감사합니다 $name"
    }

    println(phrase)
}
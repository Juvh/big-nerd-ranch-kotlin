package chapter10

private const val TAVERN_NAME = "Taernyl's Folly"

private var playerGold = 10
private var playerSiver = 10
private val patronList: List<String> = listOf("Eli", "Mordoc", "Sophie")

fun main(args: Array<String>) {
    //placeOrder("shandy,Dragon's Breath,5.91")

    println(patronList)

    // use element
    println(patronList[0])
    println(patronList.first())
    println(patronList.last())

    // getOrElse
    val orElse = patronList.getOrElse(4) { "Unknown Patron" }
    println(orElse)

    // getOrNull
    val orNull = patronList.getOrNull(4) ?: "Unknown Patron2"
    println(orNull)

    // check element
    if (patronList.contains("Eli")) {
        println("술집 주인이 말한다: Eli는 안쪽 방에서 카드하고 있어요.")
    } else {
        println("술집 주인이 말한다: Eli는 여기 없어요.")
    }

    if (patronList.containsAll(listOf("Mordoc", "Sophie"))) {
        println("술집 주인이 말한다: 네 모두 있어요.")
    } else {
        println("술집 주인이 말한다: 아니오 나간 사람도 있습니다.")
    }
}
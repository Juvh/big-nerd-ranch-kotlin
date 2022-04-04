@file:JvmName("Hero")

package juv.study.books.bnr.interop

import java.io.IOException

fun main(args: Array<String>) {
    val adversary = Jhava()
    println(adversary.utterGreeting())

    val friendshipLevel = adversary.determineFriendshipLevel()
    // println(friendshipLevel?.lowercase())
    println(friendshipLevel?.lowercase() ?: "무슨 의미인지 난해하군요")
    val adversaryHitPoints = adversary.hitPoints
    println(adversaryHitPoints.dec())
    println(adversaryHitPoints.javaClass)

    adversary.greeting = "안녕하세요, 용사시여."
    println(adversary.utterGreeting())

    adversary.offerFood()

    try {
        adversary.extendHandInFriendship()
    } catch (e: java.lang.Exception) {
        println("잘가라, 못된 괴물아!")
    }
}

val translator = { utterance: String -> println(utterance.lowercase().capitalize()) }

fun makeProclamation() = "Hi, Monster!"

@JvmOverloads
fun handOverFood(leftHand: String = "Strawberry", rightHand: String = "Meat") {
    println("맛있는 $leftHand 와 $rightHand 를 넘겨주었습니다.")
}

@Throws(IOException::class)
fun acceptApology() {
    throw IOException()
}

class SpellBook {
    @JvmField
    val spells = listOf("Magic Ms. L", "Lay on Hans")

    companion object {
        @JvmField
        val MAX_SPELL_COUNT = 10

        @JvmStatic
        fun getSpellBookGreeting() = println("나는 위대한 그리모어다!")
    }
}
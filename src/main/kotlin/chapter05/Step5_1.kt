package chapter05

fun main(vararg args: String) {
    val numLetters = "Mississippi".count()
    println(numLetters)
    val numSLetters = "Mississippi".count { letter -> letter == 's' }
    println(numSLetters)
}
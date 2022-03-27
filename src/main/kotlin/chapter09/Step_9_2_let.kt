package chapter09

fun main(args: Array<String>) {
    // without `let`
    val firstElement: Int = listOf(1, 2, 3).first()
    val firstItemSquared1: Int = firstElement * firstElement

    // with `let`
    val firstItemSquared: Int = listOf(1, 2, 3).first().let { it * it }
}
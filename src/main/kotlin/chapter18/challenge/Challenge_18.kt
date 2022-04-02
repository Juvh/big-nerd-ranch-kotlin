package chapter18.challenge

fun String.frame(padding: Int, formatChar: String = "*"): String {
    val greeting = "$this!"
    val middle = formatChar.padEnd(padding)
        .plus(greeting)
        .plus(formatChar.padStart(padding))
    val end = (0 until middle.length).joinToString("") { formatChar }
    return "$end\r\n$middle\r\n$end"
}

fun main(args: Array<String>) {
    println("Welcom, Madrigal".frame(5))
}
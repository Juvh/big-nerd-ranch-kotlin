package chapter18.sandbox.step1

private fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)

private fun Any.easyPrint() = println(this)

fun main(args: Array<String>) {
    println("Madrigal이 그 건물에서 나왔습니다".addEnthusiasm())
    "Madrigal이 그 건물에서 나왔습니다".addEnthusiasm().easyPrint()
    42.easyPrint()
}
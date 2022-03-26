package chapter06

fun main(vararg args: String) {
    var signatureDrink = "Beer"
    // signatureDrink = null    // ERROR!!

    var beverage = readLine()
    println(beverage)

    beverage = null
    println(beverage)
}
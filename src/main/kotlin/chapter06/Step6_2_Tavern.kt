package chapter06

fun main(vararg args: String) {
    // var beverage = readLine().capitalize()   // ERROR

    // 1-1. safe call operator (?.)
    var beverage1 = readLine()?.capitalize()
    println(beverage1)

    // 1-2 safe call operator with let
    var beverage1WithLet = readLine()?.let {
        if (it.isNotBlank()) {
            it.capitalize()
        } else {
            "Beer"
        }
    }
    println(beverage1WithLet)

    // 2. non-null assertion operator (!!)
    var beverage2 = readLine()!!.capitalize()
    println(beverage2)

    // 3. check with if statement
    var beverage3 = readLine()
    if (beverage3 != null) {
        beverage3 = beverage3.capitalize()
    } else {
        println("beverage3이 null입니다.")
    }
    println(beverage3)

    // Extra) null coalescing operator (elvis operator)
    val beverageServed: String = beverage3 ?: "Beer"
    println(beverageServed)
}
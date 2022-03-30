package chapter14.typecast

import chapter14.nyethack.Player
import chapter14.nyethack.Room

fun main(args: Array<String>) {

}

private fun printIsSourceOfBlessings(any: Any) {
    val isSourceOfBlessings = if (any is Player) {
        any.blessed // Smart Casting
    } else {
        // Type Casting
        (any as Room).name == "Fount of Blessings"
    }
    println("$any is a source of blessings: $isSourceOfBlessings")
}
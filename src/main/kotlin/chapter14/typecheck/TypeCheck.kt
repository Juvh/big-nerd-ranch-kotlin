package chapter14.typecheck

import chapter14.nyethack.Room
import chapter14.nyethack.TownSquare

fun main(args: Array<String>) {
    val room = Room("Foyer")
    println(room is Room)
    println(room is TownSquare)

    val townSquare: Room = TownSquare()
    println(townSquare is Room)
    println(townSquare is TownSquare)

    val className = when(townSquare) {
        is TownSquare -> TownSquare::class.simpleName
        is Room -> Room::class.simpleName
        else -> throw IllegalArgumentException()
    }
    println(className)
}
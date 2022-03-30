package chapter13.challenge

import java.util.*

class Sword(_name: String) {
    var name = _name
        get() = "The Legendary $field"
        set(value) {
            field = value.lowercase()
                .reversed()
                .replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
        }

    init {
        name = _name
    }
}

fun main(args: Array<String>) {
    val sword = Sword("Excalibur")
    println(sword.name)

    sword.name = "Gleipnir"
    println(sword.name)
}
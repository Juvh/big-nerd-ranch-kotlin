package chapter09

import java.io.File

fun main(args: Array<String>) {
    // Case 1
    val menuFile = File("menu-file.txt")
    val servesDragonsBreath: Boolean = menuFile.run {
        readText().contains("Dragon's Breath")
    }

    // Case 2
    fun nameIsLong(name: String) = name.length >= 20

    "Madrigal".run(::nameIsLong)
    "Polarcubis, Suprem Master of NyeHack".run(::nameIsLong)

    // Case 3
    fun playerCreateMessage(nameTooLong: Boolean) =
        if (nameTooLong) "Name is Too Long. Please choose another name."
        else "Welcome, adventurer"

    // with `run`
    "Polarcubis, Suprem Master of NyeHack"
        .run(::nameIsLong)
        .run(::playerCreateMessage)
        .run(::println)

    // without `run`
    println(playerCreateMessage(nameIsLong("Polarcubis, Suprem Master of NyeHack")))
}
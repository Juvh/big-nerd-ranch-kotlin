package chapter09

import java.io.File

fun main(args: Array<String>) {
    var fileContents: List<String>
    val result: File = File("file.txt")
        .also { print(it.name) }
        .also { fileContents = it.readLines() }
}
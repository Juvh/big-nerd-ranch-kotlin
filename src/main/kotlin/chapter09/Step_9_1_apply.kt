package chapter09

import java.io.File

fun main(args: Array<String>) {
    // without `apply`
    val menuFile = File("menu-file.txt")
    menuFile.setReadable(true)
    menuFile.setWritable(true)
    menuFile.setExecutable(false)

    // with `apply`
    val menuFile2 = File("menu-file.txt").apply {
        setReadable(true)
        setWritable(true)
        setExecutable(false)
    }
}
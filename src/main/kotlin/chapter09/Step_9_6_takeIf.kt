package chapter09

import java.io.File

fun main(args: Array<String>) {
    // with `takeIf`
    val fileContents = File("file.txt")
        .takeIf { it.canRead() && it.canWrite() }
        ?.readText()

    // without `takeIf`
    val file = File("file.txt")
    val fileContents2 =
        if (file.canRead() && file.canWrite()) {
            file.readText()
        } else {
            null
        }

    // `takeUnless`
    val fileContents3 = File("myFile.txt").takeUnless { it.isHidden }?.readText()
}
package chapter09

fun main(args: Array<String>) {
    val nameTooLong = with("Polarcubis, Suprem Master of NyeHack") {
        length >= 20
    }
}
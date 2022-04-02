package chapter18.nyethack.extensions

fun <T> Iterable<T>.random(): T = this.shuffled().first()
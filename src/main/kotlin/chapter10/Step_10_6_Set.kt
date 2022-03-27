package chapter10

fun main(args: Array<String>) {
    val planets = setOf("Mercury", "Venus", "Earth", "Earth")
    println(planets)
    println(planets.contains("Earth"))
    println(planets.contains("Pluto"))
    println(planets.elementAt(2))
}
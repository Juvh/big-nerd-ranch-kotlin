package chapter05

// anonymous function with single argument
fun main(vararg args: String) {
    val greetingFunction: (String) -> String = { playerName ->
        val currentYear = 2019
        "SimVillage 방문을 환영합니다, $playerName 님! (copyright $currentYear)"
    }
    println(greetingFunction("김선달"))
}
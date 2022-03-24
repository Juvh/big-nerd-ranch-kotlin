package chapter05

// it keyword
fun main(vararg args: String) {
    val greetingFunction: (String) -> String = {
        val currentYear = 2019
        "SimVillage 방문을 환영합니다, $it 님! (copyright $currentYear)"
    }
    println(greetingFunction("김선달"))
}
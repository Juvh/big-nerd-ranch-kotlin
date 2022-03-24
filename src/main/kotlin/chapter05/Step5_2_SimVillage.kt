package chapter05

// anonymous function
fun main(vararg args: String) {
    println({
        val currentYear = 2019
        "SimVillage 방문을 환영합니다, 촌장님! (copyright $currentYear)"
    }())
}
package chapter05

// inline function
fun main(vararg args: String) {
    runSimulation("김선달") { playerName: String, numBildings: Int ->
        val currentYear = 2019
        println("$numBildings 채의 건물이 추가됨")
        "SimVillage 방문을 환영합니다, $playerName 님! (copyright $currentYear)"
    }
}

private inline fun runSimulation(playerName: String, greetingFunction: (String, Int) -> String) {
    val numBuildings = (1..3).shuffled().last()
    println(greetingFunction(playerName, numBuildings))
}

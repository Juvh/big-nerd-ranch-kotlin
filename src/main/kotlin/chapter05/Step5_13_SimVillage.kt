package chapter05

// return function type
fun main(vararg args: String) {
    runSimulation()
}

private inline fun runSimulation() {
    val greetingFunction = configureGreetingFunction()
    println(greetingFunction("김선달"))
    println(greetingFunction("김선달"))
}

private fun printConstructionCost(numBuildings: Int) {
    val cost = 500
    println("Building cost: ${cost * numBuildings}")
}

private fun configureGreetingFunction(): (String) -> String {
    val structureType = "Hospital"
    var numBuildings = 5
    return { playerName: String ->
        val currentYear = 2019
        numBuildings += 1
        println("$numBuildings 채의 $structureType 이 추가됨.")
        "SimVillage 방문을 환영합니다, $playerName 님! (copyright $currentYear)"
    }
}
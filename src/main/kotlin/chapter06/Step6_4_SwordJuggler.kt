package chapter06

fun main(vararg args: String) {
    var swordsJuggling: Int? = null

    val isJugglingProficient = (1..3).shuffled().last() == 3
    if (isJugglingProficient) {
        swordsJuggling = 2
    }

    proficiencyCheck(swordsJuggling)
    swordsJuggling = swordsJuggling!!.plus(1)

    println("$swordsJuggling 개의 칼로 저글링합니다!")
}

private fun proficiencyCheck(swordsJuggling: Int?) {
    swordsJuggling ?: throw IllegalStateException("플레이어가 저글링을 할 수 없음")
}

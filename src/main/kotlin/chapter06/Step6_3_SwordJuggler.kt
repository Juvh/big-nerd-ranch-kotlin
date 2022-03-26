package chapter06

fun main(vararg args: String) {
    var swordsJuggling: Int? = null

    val isJugglingProficient = (1..3).shuffled().last() == 3
    if (isJugglingProficient) {
        swordsJuggling = 2
    }

    swordsJuggling = swordsJuggling!!.plus(1)   // NPE 발생 가능 , Unhandled Exception

    println("$swordsJuggling 개의 칼로 저글링합니다!")
}
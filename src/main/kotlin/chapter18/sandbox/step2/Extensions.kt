package chapter18.sandbox.step2

private val String.numVowels
    get() = count { "aeiouy".contains(it) }

private fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)

private fun <T> T.easyPrint(): T {
    println(this)
    return this
}

private infix fun String?.printWithDefault(default: String) = print(this ?: default)

fun main(args: Array<String>) {
    "Madrigal이 그 건물에서 나왔습니다".easyPrint().addEnthusiasm().easyPrint()
    42.easyPrint()
    "How many vowels?".numVowels.easyPrint()

    val nullableString: String? = null
    nullableString printWithDefault "Default String"
}
package chapter13.lateinit

class Wheel {
    lateinit var alignment: String
    fun initAlignment() {
        alignment = "GOOD"
    }

    fun printAlignment() {
        if (::alignment.isInitialized) println(alignment)
    }
}
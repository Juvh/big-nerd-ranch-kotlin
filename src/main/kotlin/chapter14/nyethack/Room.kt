package chapter14.nyethack

// class Room(val name: String) {
open class Room(val name: String) {

    protected open val dangerLevel = 5

    // fun description() = "Room: $name"
    fun description() = "Room: $name\r\n" +
            "위험 수준: $dangerLevel"

    // fun load() = "아무도 여기에 오지 않았습니다..."
    open fun load() = "아무도 여기에 오지 않았습니다..."
}

// class TownSquare : Room("Town Square") {
open class TownSquare : Room("Town Square") {
    override val dangerLevel = super.dangerLevel - 3
    private var bellSound = "DangDang"

    // override fun load() = "당신의 참여를 주민들이 다 함께 환영합니다!\r\n${ringBell()}"
    final override fun load() = "당신의 참여를 주민들이 다 함께 환영합니다!\r\n${ringBell()}"

    private fun ringBell() = "당신의 도착을 종탑에서 알립니다. $bellSound"
}
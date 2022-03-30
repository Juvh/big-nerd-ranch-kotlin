package chapter14.nyethack

fun main(args: Array<String>) {

    val player = Player("Madrigal")
    player.castFireball()

    // var currentRoom = Room("Foyer")
    var currentRoom: Room = TownSquare()
    println(currentRoom.description())
    println(currentRoom.load())

    // print status of player
    printPlayerStatus(player)
}

private fun printPlayerStatus(player: Player) {
    println("(Aura: ${player.auraColor()} (Blessed: ${if (player.blessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}
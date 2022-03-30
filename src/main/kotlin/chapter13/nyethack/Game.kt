package chapter13.nyethack

fun main(args: Array<String>) {

    // val player = Player("Madrigal", 89, true, false)
    val player1 = Player("Madrigal", 64, true, false)
    val player2 = Player(_name = "Madrigal", blessed = true, immortal = false)
    val player = Player("Madrigal")
    player.castFireball()

    // print status of player
    printPlayerStatus(player)
}

private fun printPlayerStatus(player: Player) {
    println("(Aura: ${player.auraColor()} (Blessed: ${if (player.blessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}
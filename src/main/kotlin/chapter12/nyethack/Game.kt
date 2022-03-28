package chapter12.nyethack

fun main(args: Array<String>) {
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    val player = Player()
    player.castFireball()

    // print status of player
    printPlayerStatus(player)
}

private fun printPlayerStatus(player: Player) {
    println("(Aura: ${player.auraColor()} (Blessed: ${if (player.blessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}
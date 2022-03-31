package chapter15.nyethack

fun main(args: Array<String>) {
    Game.play()
}

object Game {
    private val player = Player("Madrigal")
    private var currentRoom: Room = TownSquare()

    private var worldMap = listOf(
        listOf(currentRoom, Room("Tavern"), Room("Back Room")),
        listOf(Room("Long Corridor"), Room("Generic Room"))
    )

    init {
        println("방문을 환영합니다.")
        player.castFireball()
    }

    fun play() {
        var inProgress = true   // challenge 1
        while (inProgress) {
            // NyetHack Game Start.
            println(currentRoom.description())
            println(currentRoom.load())

            // print status of player
            printPlayerStatus(player)

            print("> 명령을 입력하세요: ")
            // println("최근 명령: ${readLine()}")
            val message = GameInput(readLine()).processCommand()
            println(message)
            inProgress = message != "END"   // challenge 1
        }
    }

    private fun printPlayerStatus(player: Player) {
        println("(Aura: ${player.auraColor()} (Blessed: ${if (player.blessed) "YES" else "NO"})")
        println("${player.name} ${player.formatHealthStatus()}")
    }

    private class GameInput(arg: String?) {
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1) { "" }

        fun processCommand() = when (command.lowercase()) {
            "move" -> move(argument)
            "ring" -> ringBell()
            "map" -> displayMap()   // challenge 2
            "quit", "exit" -> "END" // challenge 1
            else -> commandNotFound()
        }

        private fun ringBell() =
            (currentRoom as? TownSquare)?.ringBell() ?: "광장에서만 종을 칠 수 있습니다."


        // challenge 2
        private fun displayMap(): String =
            worldMap.joinToString("\n") { rooms ->
                rooms.joinToString(" ") { room ->
                    if (room == currentRoom) "X" else "O"
                }
            }


        private fun commandNotFound() = "적합하지 않은 명령입니다!"
    }

    private fun move(directionInput: String) =
        try {
            val direction = Direction.valueOf(directionInput.uppercase())
            val newPosition = direction.updateCoordinate(player.currentPosition)
            if (!newPosition.isInBounds) {
                throw IllegalStateException("$direction 쪽 방향이 범위를 벗어남.")
            }

            val newRoom = worldMap[newPosition.y][newPosition.x]
            player.currentPosition = newPosition
            currentRoom = newRoom
            "OK, $direction 방향의 ${newRoom.name}로 이동했습니다."
        } catch (e: Exception) {
            "잘못된 방향임 : $directionInput."
        }
}
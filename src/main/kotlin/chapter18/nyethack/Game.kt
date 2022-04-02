package chapter18.nyethack

import kotlin.system.exitProcess

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
        while (true) {
            // NyetHack Game Start.
            println(currentRoom.description())
            println(currentRoom.load())

            // print status of player
            printPlayerStatus(player)

            print("> 명령을 입력하세요: ")
            // println("최근 명령: ${readLine()}")
            println(GameInput(readLine()).processCommand())
        }
    }

    private fun printPlayerStatus(player: Player) {
        println("(Aura: ${player.auraColor()} (Blessed: ${if (player.blessed) "YES" else "NO"})")
        println("${player.name} ${player.formatHealthStatus()}")
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

    private fun fight() = currentRoom.monster?.let {
        while (player.healthPoints > 0 && it.healthPoints > 0) {
            slay(it)
            Thread.sleep(1000)
        }

        "전투가 끝났음."
    } ?: "여기에는 싸울 괴물이 없습니다...."

    private fun slay(monster: Monster) {
        println("${monster.name} -- ${monster.attack(player)} 손상을 입힘!")
        println("${player.name} -- ${player.attack(monster)} 손상을 입힘!")

        if (player.healthPoints <= 0) {
            println(">>>> 당신은 졌습니다! 게임을 종료합니다.. <<<<")
            exitProcess(0)
        }

        if (monster.healthPoints <= 0) {
            println(">>>> ${monster.name} 격퇴됨! <<<<")
            currentRoom.monster = null
        }
    }

    private class GameInput(arg: String?) {
        private val input = arg ?: ""
        val command = input.split(" ")[0]

        val argument = input.split(" ").getOrElse(1) { "" }

        fun processCommand() = when (command.lowercase()) {
            "move" -> move(argument)
            "ring" -> ringBell()
            "map" -> displayMap()   // challenge 2
            "fight" -> fight()
            "quit", "exit" -> exitProcess(0) // challenge 1
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
}
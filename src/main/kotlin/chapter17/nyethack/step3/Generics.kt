package chapter17.nyethack.step3

class LootBox<T : Loot>(vararg item: T) {
    var open = false
    var loot: Array<out T> = item

    operator fun get(idx: Int): T? = loot[idx].takeIf { open }

    fun fetch(idx: Int): T? {
        return loot[idx].takeIf { open }
    }

    fun <R> fetch(idx: Int, lootModFunction: (T) -> R): R? {
        return lootModFunction(loot[idx]).takeIf { open }
    }
}

open class Loot(val value: Int)

class Fedora(val name: String, value: Int) : Loot(value)

class Coin(value: Int) : Loot(value)

fun main(args: Array<String>) {
    val lootBoxOne: LootBox<Fedora> = LootBox(
        Fedora("Normal Fedora", 15),
        Fedora("Brilliant Purple Fedora", 25)
    )
    val lootBoxTwo: LootBox<Coin> = LootBox(Coin(15))

    lootBoxOne.open = true
    lootBoxOne.fetch(1)?.run {
        println("$name 를 LootBox에서 꺼냈습니다.")
    }

    val coin = lootBoxOne.fetch(0) {
        Coin(it.value * 3)
    }

    coin?.let { println(it.value) }

    val fedora = lootBoxOne[1]
    fedora?.let { println(it.name) }

}
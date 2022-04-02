package chapter17.sandbox.step1

private class LootBox<T>(item: T) {
    var open = false
    private var loot: T = item

    fun fetch(): T? {
        return loot.takeIf { open }
    }

    fun <R> fetch(lootModFunction: (T) -> R): R? {
        return lootModFunction(loot).takeIf { open }
    }
}

private class Fedora(val name: String, val value: Int)

private class Coin(val value: Int)

fun main(args: Array<String>) {
    val lootBoxOne: LootBox<Fedora> = LootBox(Fedora("Normal Fedora", 15))
    val lootBoxTwo: LootBox<Coin> = LootBox(Coin(15))

    lootBoxOne.open = true
    lootBoxOne.fetch()?.run {
        println("$name 를 LootBox에서 꺼냈습니다.")
    }

    val coin = lootBoxOne.fetch {
        Coin(it.value * 3)
    }

    coin?.let { println(it.value) }

}
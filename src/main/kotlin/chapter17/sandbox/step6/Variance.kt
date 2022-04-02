package chapter17.sandbox.step6

class Barrel<in T>(item: T)

open class Loot(val value: Int)

class Fedora(val name: String, value: Int) : Loot(value)

class Coin(value: Int) : Loot(value)

fun main(args: Array<String>) {
    var fedoraBarrel: Barrel<Fedora> = Barrel(Fedora("Normal Fedora", 15))
    var lootBarrel: Barrel<Loot> = Barrel(Coin(15))

    fedoraBarrel = lootBarrel
}
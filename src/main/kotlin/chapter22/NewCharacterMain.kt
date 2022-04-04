package chapter22

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun main(args: Array<String>) {
    // val characterData = CharacterGenerator.fromApiData("halfling,Lars Kizzy, 14,13,8")
    /*val characterData = fetchCharacterData()
    displayCharacterData(characterData)*/

    GlobalScope.launch(Dispatchers.Default) {
        val characterData = fetchCharacterDataWithCoroutine().await()
        displayCharacterData(characterData)
    }

    Thread.sleep(3000)
}

fun displayCharacterData(characterData: CharacterGenerator.CharacterData) {
    val message = """name : ${characterData.name}
        |race : ${characterData.race}
        |stats : [ wisdom: ${characterData.wis} , strength: ${characterData.str} , dexterity: ${characterData.dex} ]
    """.trimMargin()

    println(message)
}
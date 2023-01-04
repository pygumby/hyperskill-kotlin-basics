class Spell(val name: String, val power: Int)

// Added extension function
fun Spell.toStringAlt() = "Spell(name=${this.name}, power=${this.power})"

fun main() {
    val input = readln().split(" ")
    val spells = input.map { Spell(it.split("-")[0], it.split("-")[1].toInt()) }

    // write your code here
    println(spells.takeWhile { it.power > 50 }.map { it.toStringAlt() })
}

open class Character(val name: String)
class Jedi(name: String, val age: Int) : Character(name)
class Sith(name: String, val hasMask: Boolean) : Character(name)

fun characterBuilder(input: String): Character {
    val (name, type, other) = input.split("-")
    return when (type) {
        "jedi" -> Jedi(name, other.toInt())
        "sith" -> Sith(name, other.toBoolean())
        else -> throw IllegalArgumentException("Unknown character type: $type")
    }
}

fun main() {
   val list = readln().split(" ")
   val characters = list.map { characterBuilder(it) }

    // write your code here
    val (jedis, siths) = characters.partition { it is Jedi }

    println("jedis: ${jedis.size}, siths: ${siths.size}")
}

data class Ship(val name: String, val ammunition: Int)

fun main() {
    val ships = readln().split(" ")
    val shipsList = ships.map { Ship(it.split("-")[0], it.split("-")[1].toInt()) }

    // write your code here
    println(shipsList.findLast { it.ammunition > 200 }?.name ?: "No ship found")
}

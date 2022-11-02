data class Ship(val name: String, val ammunition: Int)

fun main() {
    val ships = readln().split(" ")
    val shipsList = ships.map { Ship(it.split("-")[0], it.split("-")[1].toInt()) }

    // write your code here
    val res = shipsList
        .groupingBy { it.name }
        .fold(0) { acc, ship -> acc + ship.ammunition }

    println(res)
}

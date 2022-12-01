data class Ship(val name: String, val ammunition: Int)

fun main() {
    val ships = readln().split(" ")
    val shipsList = ships.map { Ship(it.split("-")[0], it.split("-")[1].toInt()) }
    val shipsNames = shipsList.map { ship -> ship.name }
    val shipsAmmo = shipsList.map { ship -> ship.ammunition }

    // write your code here
    val res = shipsNames.zip(shipsAmmo) { shipName, shipAmmo -> shipName to shipAmmo * 2 }

    println(res)
}

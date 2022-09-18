fun main() {
    val h1 = readln().toInt()
    val h2 = readln().toInt()
    val h3 = readln().toInt()
    val ascending = h1 <= h2 && h2 <= h3
    val descending = h1 >= h2 && h2 >= h3
    println(ascending || descending)
}

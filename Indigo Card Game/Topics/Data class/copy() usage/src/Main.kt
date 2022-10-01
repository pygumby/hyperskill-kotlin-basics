// do not change this data class
data class Box(val height: Int, val length: Int, val width: Int)

fun main() {
    val h1 = readln().toInt()
    val l1 = readln().toInt()
    val l2 = readln().toInt()
    val w1 = readln().toInt()

    val b1 = Box(h1, l1, w1)
    val b2 = b1.copy(length = l2)

    println(b1)
    println(b2)
}

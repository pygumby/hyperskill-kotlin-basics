import java.util.*

fun main() {
    val list = readln().split(" ").map { it.toInt() }

    // write your code here
    println(list.reversed().joinToString(" "))
}

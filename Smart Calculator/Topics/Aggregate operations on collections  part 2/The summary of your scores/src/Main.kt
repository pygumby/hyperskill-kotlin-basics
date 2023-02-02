fun main() {
    val list = readln().split(" ").map { it.toDouble() }

    // write your code here
    println("${list.maxOrNull()}:${list.minOrNull()}:${list.average()}")
}

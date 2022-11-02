fun main() {
    val list = readln().split(" ").map { it.toDouble() }
    // write your code here
    val res = list.fold(0.0) { acc, d -> acc + d / list.size }

    println(res)
}

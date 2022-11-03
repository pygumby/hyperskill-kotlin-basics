fun main() {
    val list = readln().split(" ").map { it.toInt() }
    // write your code here
    val res = list.sortedWith(compareBy { it % 2 == 0 })

    println(res)
}

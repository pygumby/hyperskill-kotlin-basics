fun main() {
    val list = readln().split(" ")
    // write your code here
    val res = list.sortedBy { it.first().lowercase() }

    println(res)
}

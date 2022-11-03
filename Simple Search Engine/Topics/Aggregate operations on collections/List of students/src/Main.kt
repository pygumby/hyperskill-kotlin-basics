fun main() {
    val list = readln().split(" ")
    // write your code here
    val res = list.maxByOrNull { it.first() }

    println(res)
}

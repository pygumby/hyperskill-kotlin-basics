fun main() {
    val list = readln().split(" ")
    // write your code here
    val res = list.any { it.lowercase() == "secret" }

    println(!res)
}

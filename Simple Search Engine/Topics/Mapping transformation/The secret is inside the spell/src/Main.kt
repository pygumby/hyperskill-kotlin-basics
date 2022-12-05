/* Do not change code below */
fun main() {
    val list = readln().split(" ")
    // write your code here
    val res = list.map { it.last() }.joinToString("")

    println(res)
}

/* Do not change code below */
fun main() {
    val list = readln().split(" ")
    // write your code here
    val res = list.associate { it.first().uppercase() to it.length }

    println(res)
}

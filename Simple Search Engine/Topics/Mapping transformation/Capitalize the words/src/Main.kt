fun main() {
    val list = readln().split(" ")
    // write your code here
    val res = list.map { it.replaceFirstChar { it.uppercase() } }

    println(res)
}

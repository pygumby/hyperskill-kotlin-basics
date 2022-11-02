fun main() {
    val list = readln().split(" ")
    // write your code here
    val res = list
        .groupingBy { it.first() }
        .fold("") { acc, s -> if (s.length > acc.length) s else acc }

    println(res)
}

fun main() {
    val list = readln().split(" ")
    // write your code here
    val res = list
        //.take(if (list.size % 2 == 0) list.size else list.size - 1)
        .windowed(2, 2) { it.sumOf { it.length } }

    println(res)
}

fun main() {
    val list = readln().split(" ")
    // write your code here
    val res = list.foldIndexed(0) { i, acc, s -> acc + if (i % 2 == 0) s.length else 0 }

    println(res)
}

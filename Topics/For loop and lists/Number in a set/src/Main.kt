fun main() {
    val n = readln().toInt()
    val lst = mutableListOf<Int>()

    for (i in 0 until n) {
        lst.add(readln().toInt())
    }

    val m = readln().toInt()
    println(if (lst.contains(m)) "YES" else "NO")
}

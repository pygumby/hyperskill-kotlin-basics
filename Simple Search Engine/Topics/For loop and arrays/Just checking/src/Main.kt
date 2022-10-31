fun main() {
    val n = readln().toInt()
    val a = IntArray(n)

    for (i in 0..a.lastIndex) {
        a[i] = readln().toInt()
    }

    val pm = readln().split(" ").map { it.toInt() }

    println(if (a.contains(pm[0]) && a.contains(pm[1])) "YES" else "NO")
}

fun main() {
    val n = readln().toInt()
    val a = IntArray(n)

    for (i in 0..a.lastIndex) {
        a[i] = readln().toInt()
    }

    var triples = 0
    for (i in a.indices) {
        if (i <= n - 3 && a[i] == a[i + 1] - 1 && a[i + 1] == a[i + 2] - 1) triples++
    }

    println(triples)
}

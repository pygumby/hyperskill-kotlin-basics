fun sumRecursive(n: Int): Int {
    if (n == 0) {
        return 0
    } else {
        return n + sumRecursive(n - 1)
    }
}

fun main() {
    val n = readLine()!!.toInt()
    print(sumRecursive(n))
}

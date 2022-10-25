fun isPrime(n: Int, i: Int = 2): Boolean {
    if (n <= 2) return n == 2
    if (n % i == 0) return false
    if (i * i > n) return true

    return isPrime(n, i + 1)
}

fun main() {
    val n = readLine()!!.toInt()
    print(isPrime(n))
}

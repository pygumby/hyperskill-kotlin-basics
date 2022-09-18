const val HUNDRED = 100
const val TEN = 10

fun main() {
    val n = readln().toInt()
    val hundreds = n / HUNDRED
    val tens = n % HUNDRED / TEN
    val ones = n % HUNDRED % TEN
    println(hundreds + tens + ones)
}

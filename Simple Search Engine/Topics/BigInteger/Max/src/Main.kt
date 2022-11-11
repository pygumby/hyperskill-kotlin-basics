import java.math.BigInteger

fun main() {
    // write your code here
    val a = BigInteger(readln())
    val b = BigInteger(readln())

    println((a + b + (a - b).abs()) / BigInteger.TWO)
}

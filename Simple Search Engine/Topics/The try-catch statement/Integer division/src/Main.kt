import java.lang.NumberFormatException

fun intDivision(x: String, y: String): Int =
    try {
        x.toInt() / y.toInt()
    } catch (_: NumberFormatException) {
        println("Read values are not integers.")
        0
    } catch (_: ArithmeticException) {
        println("Exception: division by zero!")
        0
    }


fun main() {
    val x = readLine()!!
    val y = readLine()!!
    println(intDivision(x, y))
}

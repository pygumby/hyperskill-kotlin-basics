import java.math.BigDecimal
import java.math.RoundingMode     

fun main() {
    // write your code here
    val power = readln().toInt()
    val mode = readln().toInt()
    val bi = BigDecimal(readln())

    val newBi = bi.setScale(mode, RoundingMode.FLOOR).pow(power)

    println(newBi)
}

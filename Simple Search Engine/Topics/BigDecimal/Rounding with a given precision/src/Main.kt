import java.math.BigDecimal
import java.math.RoundingMode

fun main() {             
    val bd = BigDecimal(readln())
    val newBd = bd.setScale(readln().toInt(), RoundingMode.HALF_DOWN)
    println(newBd)
}

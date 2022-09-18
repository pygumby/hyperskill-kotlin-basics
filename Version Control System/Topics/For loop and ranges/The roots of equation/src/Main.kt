import kotlin.math.pow

fun pow(i: Int, exp: Int): Int {
    return i.toDouble().pow(exp).toInt()
}

const val THOUSAND = 1000

fun main() {
    val a = readln().toInt()
    val b = readln().toInt()
    val c = readln().toInt()
    val d = readln().toInt()

    for (x in 0..THOUSAND) {
        val res = a * pow(x, 3) + b * pow(x, 2) + c * x + d
        if (res == 0) {
            println(x)
        }
    }
}

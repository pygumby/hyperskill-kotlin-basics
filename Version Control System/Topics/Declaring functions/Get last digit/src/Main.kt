// write your code here
const val TEN = 10

fun getLastDigit(n: Int): Int {
    val abs = Math.abs(n)
    return if (abs >= TEN) getLastDigit(abs % TEN) else abs
}

/* Do not change code below */
fun main() {
    val a = readLine()!!.toInt()
    println(getLastDigit(a))
}
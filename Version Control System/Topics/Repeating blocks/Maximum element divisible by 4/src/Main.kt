const val FOUR = 4

fun main() {
    val n = readln().toInt()
    var largest = 0

    repeat(n) {
        val next = readln().toInt()
        if (next % FOUR == 0 && next > largest) {
            largest = next
        }
    }

    println(largest)
}

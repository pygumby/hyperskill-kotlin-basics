
fun main() {
    val n = readln().toInt()

    var larger = 0
    var smaller = 0
    var perfect = 0

    repeat(n) {
        val next = readln().toInt()
        if (next == 1) {
            larger++
        } else if (next == -1) {
            smaller++
        } else {
            perfect++
        }
    }

    println("$perfect $larger $smaller")
}

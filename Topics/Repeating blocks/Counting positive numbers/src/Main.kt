fun main() {
    val n = readln().toInt()
    var positives = 0

    repeat(n) {
        val next = readln().toInt()
        if (next > 0) {
            positives++
        }
    }

    println(positives)
}

fun main() {
    val numberOfButterCups = readln().toInt()
    val isWeekend = readln().toBoolean()

    println(
        if (isWeekend) {
            numberOfButterCups in 15..25
        } else {
            numberOfButterCups in 10..20
        }
    )
}

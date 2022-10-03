fun main() {
    val ship1 = readln().split(" ").map { it.toInt() }.let { it[0] to it[1] }
    val ship2 = readln().split(" ").map { it.toInt() }.let { it[0] to it[1] }
    val ship3 = readln().split(" ").map { it.toInt() }.let { it[0] to it[1] }

    val emptyRows = mutableListOf<Int>()
    for (x in 1..5) {
        if (x == ship1.first || x == ship2.first || x == ship3.first) continue
        emptyRows.add(x)
    }

    val emptyColumns = mutableListOf<Int>()
    for (y in 1..5) {
        if (y == ship1.second || y == ship2.second || y == ship3.second) continue
        emptyColumns.add(y)
    }

    println(emptyRows.joinToString(" "))
    println(emptyColumns.joinToString(" "))
}

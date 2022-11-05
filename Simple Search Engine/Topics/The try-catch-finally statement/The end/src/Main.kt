fun solution() {
    // write here
    val i = readln().toInt()
    val j = readln().toInt()

    try {
        println(i / j)
    } catch (e: Exception) {
        println(e.message)
    } finally {
        println("This is the end, my friend.")
    }
}

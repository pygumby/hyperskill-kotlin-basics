fun main() {
    val size = readln().toInt()
    val list = mutableListOf<Int>()

    for (i in 0 until size) {
        list.add(readln().toInt())
    }

    val pm = readln().split(" ")
    val p = pm[0].toInt()
    val m = pm[1].toInt()

    println(if (list.contains(p) && list.contains(m)) "YES" else "NO")
}

fun main() {
    val list = readln().split(" ").map { it.toInt() }

    // write your code here
    val res = mutableListOf<Int>()
    val deq = ArrayDeque<Int>()

    deq.addAll(list)
    repeat(list.size) { i -> res.add(if (i % 2 == 0) deq.removeFirst() else deq.removeLast()) }

    println(res.joinToString(" "))
}

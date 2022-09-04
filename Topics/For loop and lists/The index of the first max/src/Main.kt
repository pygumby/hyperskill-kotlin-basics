fun main() {
    // write your code here
    val n = readln().toInt()
    val lst = mutableListOf<Int>()
    var max = 0

    for (i in 0 until n) {
        lst.add(readln().toInt())
        if (lst[i] > lst[max]) {
            max = i
        }
    }

    println(max)
}

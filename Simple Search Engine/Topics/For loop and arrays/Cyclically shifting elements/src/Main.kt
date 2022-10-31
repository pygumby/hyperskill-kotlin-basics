fun main() {
    val n = readln().toInt()
    val a = IntArray(n)

    for (i in 0..a.lastIndex) {
        a[i] = readln().toInt()
    }

    print("${a[a.lastIndex]} ")
    for (i in 0 until a.lastIndex) {
        print("${a[i]} ")
    }
}

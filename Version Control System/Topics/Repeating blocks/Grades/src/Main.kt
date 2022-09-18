fun main() {
    val n = readln().toInt()

    var a = 0
    var b = 0
    var c = 0
    var d = 0

    for (i in 0 until n) {
        when (readln().toInt()) {
            2 -> d++
            3 -> c++
            4 -> b++
            5 -> a++
        }
    }

    println("$d $c $b $a")
}

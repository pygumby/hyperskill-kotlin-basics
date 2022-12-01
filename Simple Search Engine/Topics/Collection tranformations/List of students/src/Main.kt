fun main() {
    val list = readln().split(" ")
    // write your code here
    val namesWithLength = list.associateWith { it.length }.toList()
    val string = namesWithLength.joinToString(separator = ", ", limit = 2, truncated = "*") {
        "${it.first}->${it.second}"
    }

    println(string)
}

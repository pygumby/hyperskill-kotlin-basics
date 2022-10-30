fun main() {
    val list = readln().split(" ")
    // write your code
    val it = list.iterator()

    val map = mutableMapOf<String, Int>()

    while (it.hasNext()) {
        val word = it.next()
        map[word] = (map[word] ?: 0) + 1
    }

    map.forEach { (word, count) -> println("$word $count") }
}

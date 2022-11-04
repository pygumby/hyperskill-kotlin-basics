fun main() {
    val words: List<String> = readln().split(" ")

    val firstLetter = words.first().first()

    if (words.filter { it.startsWith(firstLetter) }.size == words.size) {
        println(words.joinToString(" "))
    } else {
        println()
    }
}

package search

fun main() {
    val words = readln().split(" ")
    val searchTerm = readln()

    val searchTermIndex = words.indexOf(searchTerm)
    println(if (searchTermIndex == -1) "Not found" else searchTermIndex + 1)
}

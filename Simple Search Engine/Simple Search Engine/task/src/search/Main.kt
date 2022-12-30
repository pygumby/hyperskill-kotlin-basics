package search

import java.io.File

data class Ref(val lineIndex: Int, val wordIndex: Int)

class SearchEngine {
    private val invertedIndex = mutableMapOf<String, Set<Ref>>()

    fun initLinesFromStdIn() {
        println("Enter the number of people:")
        val numberOfLines = readln().toInt()

        println("Enter all people:")
        val lines = List(numberOfLines) { readln() }
        this.initInvertedIndex(lines)
    }

    fun initLinesFromFile(path: String) {
        val lines = File(path).useLines { it.toList() }
        this.initInvertedIndex(lines)
    }

    private fun initInvertedIndex(lines: List<String>) = lines.forEachIndexed { lineIndex, line ->
        line.split(" ").forEachIndexed { wordIndex, word ->
            this.invertedIndex[word] = this.invertedIndex.getOrDefault(word, setOf()) + Ref(lineIndex, wordIndex)
        }
    }

    private fun getLineByIndex(lineIndex: Int): String {
        val line = mutableListOf<Pair<Int, String>>()

        this.invertedIndex.forEach { (word, setOfRefs) ->
            setOfRefs.forEach { ref ->
                if (ref.lineIndex == lineIndex) line.add(ref.wordIndex to word)
            }
        }

        return line
            .sortedBy { it.first }
            .joinToString(" ") { it.second }
    }

    private fun query() {
        println("\nEnter a name or email to search all suitable people:")
        val queriedWord = readln()

        val lineIndices = this.invertedIndex
            .filter { (word, _) -> word.lowercase() == queriedWord.lowercase() }
            .map { (_, setOfRefs) -> setOfRefs.map { it.lineIndex } }
            .flatten()

        if (lineIndices.isEmpty()) {
            println("No matching people found.")
        } else {
            println("\nPeople found:")
            lineIndices.forEach { println(this.getLineByIndex(it)) }
        }
    }

    private fun getAllLines() = this.invertedIndex
        .map { (_, setOfRefs) -> setOfRefs.map { it.lineIndex } }
        .flatten()
        .toSet()
        .map { getLineByIndex(it) }

    fun displayUserMenu() {
        println()
        println("""
            === Menu ===
            1. Find a person
            2. Print all people
            0. Exit
        """.trimIndent())

        when (readln().toInt()) {
            1 -> this.query()
            2 -> println("\n=== List of people ===\n${this.getAllLines().joinToString("\n")}")
            0 -> return println("\nBye!")
            else -> println("\nIncorrect option! Try again.")
        }

        this.displayUserMenu()
    }
}

fun main(args: Array<String>) {
    val searchEngine = SearchEngine()

    if (args.isNotEmpty() && args[0] == "--data") {
        searchEngine.initLinesFromFile(args[1])
    } else {
        searchEngine.initLinesFromStdIn()
    }

    searchEngine.displayUserMenu()
}

package search

import java.io.File

data class Ref(val lineIndex: Int, val wordIndex: Int)

enum class Strategy {
    ALL, ANY, NONE
}

class SearchEngine {
    private val invertedIndex = mutableMapOf<String, Set<Ref>>()
    private var numberOfLines = 0

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

    private fun initInvertedIndex(lines: List<String>) {
        this.numberOfLines = lines.size
        lines.forEachIndexed { lineIndex, line ->
            line.split(" ").forEachIndexed { wordIndex, word ->
                this.invertedIndex[word] = this.invertedIndex.getOrDefault(word, setOf()) + Ref(lineIndex, wordIndex)
            }
        }
    }

    private fun getAllLineIndices() =
        (0 until this.numberOfLines).toList()

    private fun getLineIndicesForWord(word: String) = this.invertedIndex
        .filter { (otherWord, _) -> otherWord.lowercase() == word.lowercase() }
        .map { (_, setOfRefs) -> setOfRefs.map { it.lineIndex } }
        .flatten()
        .toSet()

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
        println("\nSelect a matching strategy: ALL, ANY, NONE")
        val strategy = when (readln()) {
            "ALL" -> Strategy.ALL
            "ANY" -> Strategy.ANY
            "NONE" -> Strategy.NONE
            else -> return this.query()
        }

        println("\nEnter a name or email to search all suitable people:")
        val words = readln().split(" ")

        val lineIndicesPerWord = words.map { this.getLineIndicesForWord(it) }

        if (lineIndicesPerWord.isEmpty()) {
            return if (strategy == Strategy.NONE) {
                this.getAllLineIndices().map { this.getLineByIndex(it) }.forEach { println(it) }
            } else {
                println("No matching people found.")
            }
        }

        val lineIndices = when (strategy) {
            Strategy.ALL -> lineIndicesPerWord.reduce { acc, next -> acc.intersect(next) }
            Strategy.ANY -> lineIndicesPerWord.flatten().toSet()
            else -> this.getAllLineIndices().toSet().minus(lineIndicesPerWord.flatten().toSet())
        }

        println("\nPeople found:")
        lineIndices.forEach { println(this.getLineByIndex(it)) }
    }

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
            2 -> println("\n=== List of people ===\n${this.getAllLineIndices().joinToString("\n") { this.getLineByIndex(it) }}")
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

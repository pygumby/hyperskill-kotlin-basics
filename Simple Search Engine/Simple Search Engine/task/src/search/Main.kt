package search

class SearchEngine {
    private val data = mutableListOf<String>()

    fun promptInitialData() {
        println("Enter the number of people:")
        val nOfEntries = readln().toInt()

        println("Enter all people:")
        repeat (nOfEntries) {
            this.data.add(readln())
        }
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
            2 -> println("\n=== List of people ===\n${this.data.joinToString("\n")}")
            0 -> return println("\nBye!")
            else -> println("\nIncorrect option! Try again.")
        }

        this.displayUserMenu()
    }

    private fun query() {
        println("\nEnter a name or email to search all suitable people:")
        val query = readln().lowercase()
        val results = this.data.filter { it.lowercase().contains(query) }

        if (results.isEmpty()) {
            println("No matching people found.")
        } else {
            println("\nPeople found:")
            println(results.joinToString("\n"))
        }
    }
}

fun main() {
    val searchEngine = SearchEngine()
    searchEngine.promptInitialData()
    searchEngine.displayUserMenu()
}

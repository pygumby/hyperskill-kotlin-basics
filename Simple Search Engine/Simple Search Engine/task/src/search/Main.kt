package search

fun main() {
    println("Enter the number of people:")
    val nOfEntries = readln().toInt()

    println("Enter all people:")
    val persons = mutableListOf<String>()
    repeat (nOfEntries) {
        persons.add(readln())
    }

    println("\nEnter the number of search queries:")
    val nOfQueries = readln().toInt()

    repeat(nOfQueries) {
        println("\nEnter data to search people:")
        val query = readln().lowercase()
        val results = persons.filter { it.lowercase().contains(query) }

        if (results.isEmpty()) {
            println("No matching people found.")
        } else {
            println("\nPeople found:")
            println(results.joinToString("\n"))
        }
    }
}

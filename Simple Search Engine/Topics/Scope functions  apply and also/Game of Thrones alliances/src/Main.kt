fun main() {
    val heroesList = mutableListOf("John Snow", "Daenerys Targaryen")
    println("Old heroes list: ${heroesList.joinToString()}")

    heroesList // Write here a chain of scope functions and MutableList methods
        .apply { this.add(readln()) }
        .also { println("New heroes list: ${it.joinToString()}") }
}

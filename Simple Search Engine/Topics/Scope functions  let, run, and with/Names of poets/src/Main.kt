fun main() {
    var poet: String? = readln()

    val coolScope = poet?.let {
        println("Our poet is $it")
        it.count { char -> char.lowercase() == "a" }
    }

    println(coolScope)
}

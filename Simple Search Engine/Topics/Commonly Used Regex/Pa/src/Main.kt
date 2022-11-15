fun main() {
    val text = readln()
    // write your code here
    val matches = Regex("\\w*pa\\w*").findAll(text)
    matches.forEach { println(it.value) }
}

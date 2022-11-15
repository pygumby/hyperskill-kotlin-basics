fun main() {
    // write your code here
    val text = readln()
    val matches = Regex("([A-Z][a-z]+)(\\s[A-Z][a-z]+)?").findAll(text)
    matches.forEach { println(it.value) }
}

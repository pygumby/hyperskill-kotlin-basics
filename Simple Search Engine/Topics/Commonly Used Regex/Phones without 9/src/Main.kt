fun main() {
    // write your code here
    val numbers = readln()
    val matches = Regex("\\(?[0-8]{3}\\)?-?[0-8]{3}-?[0-8]{4}").findAll(numbers)
    matches.forEach { println(it.value) }
}

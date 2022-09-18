fun main() {
    val ch = readln().first()
    println(ch.isUpperCase() || (ch.isDigit() && ch != '0'))
}

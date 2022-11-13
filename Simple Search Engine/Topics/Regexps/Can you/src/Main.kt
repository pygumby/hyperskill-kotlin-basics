fun main() {
    val answer = readln()
    // write your code here
    val r1 = Regex("I can do my homework on time!")
    val r2 = Regex("I can't do my homework on time!")

    println(r1.matches(answer) || r2.matches(answer))
}

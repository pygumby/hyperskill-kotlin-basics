package calculator

operator fun Regex.contains(cs: CharSequence): Boolean = this.matches(cs)

fun main(): Unit = when (val input = readln()) {
    in Regex("""-?\d+\s+-?\d+""") -> {
        println(input.split(" ").sumOf { it.toInt() })
        main()
    }
    in Regex("""-?\d+""") -> {
        println(input)
        main()
    }
    "/exit" -> println("Bye!")
    else -> main()
}

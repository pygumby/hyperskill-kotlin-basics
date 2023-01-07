package calculator

operator fun Regex.contains(cs: CharSequence): Boolean = this.matches(cs)

fun main(): Unit = when (val input = readln()) {
    in Regex("""(-?\d+\s+)*-?\d+""") -> {
        println(input.split(Regex("""\s+""")).sumOf { it.toInt() })
        main()
    }
    "/help" -> {
        println("The program calculates the sum of numbers")
        main()
    }
    "/exit" -> println("Bye!")
    else -> main()
}

fun main(args: Array<String>) {
    val text = "You have chosen a"
    when (readln().toInt()) {
        1 -> println("$text square")
        2 -> println("$text circle")
        3 -> println("$text triangle")
        4 -> println("$text rhombus")
        else -> println("There is no such shape!")
    }
}

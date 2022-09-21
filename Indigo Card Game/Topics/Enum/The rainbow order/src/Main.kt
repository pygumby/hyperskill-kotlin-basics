enum class Rainbow {
    RED,
    ORANGE,
    YELLOW,
    GREEN,
    BLUE,
    INDIGO,
    VIOLET,
}

fun main() {
    val color = readln()
    println(Rainbow.valueOf(color.uppercase()).ordinal + 1)
}

const val THREE = 3
const val FIVE = 5

fun iterator(map: Map<String, Int>) {
    for ((_, v) in map) {
        if (v % THREE == 0) {
            println("Fizz")
        } else if (v % FIVE == 0) {
            println("Buzz")
        } else {
            println("FizzBuzz")
        }
    }
}

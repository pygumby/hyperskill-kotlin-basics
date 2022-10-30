fun countSum(sweets: Map<String, Int>): Int {
    // write your code
    val it = sweets.iterator()
    var sum = 0
    it.forEach { (_, price) -> sum += price }
    return sum
}

fun main() {
    val cart = mutableMapOf<String, Int>()

    val n = readln().toInt()
    repeat(n) {
        val item = readln().split(" ")
        cart[item[0]] = item[1].toInt()
    }

    // write your code
    println(countSum(cart)) // do not change this line
}

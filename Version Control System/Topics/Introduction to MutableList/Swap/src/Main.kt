fun main() {    
    val numbers = readLine()!!.split(' ').map { it.toInt() }.toMutableList()
    // Do not touch lines above
    // Write only exchange actions here.
    val tmp = numbers[0]
    numbers[0] = numbers.last()
    numbers[numbers.lastIndex] = tmp
    // Do not touch lines below
    println(numbers.joinToString(separator = " "))
}

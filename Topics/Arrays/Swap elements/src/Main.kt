fun main() {    
    val numbers = readLine()!!.split(' ').map { it.toInt() }.toIntArray()

    val tmp = numbers.first()
    numbers[0] = numbers.last()
    numbers[numbers.lastIndex] = tmp

    // Do not touch lines below
    println(numbers.joinToString(separator = " "))
}

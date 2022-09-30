fun printIfPrime(number: Int) {
    for (i in 2..number / 2) {
        if (number % i == 0) {
            return println("$number is not a prime number.")
        }
    }

    return println("$number is a prime number.")
}

fun main(args: Array<String>) {
    printIfPrime(readln().toInt())
}

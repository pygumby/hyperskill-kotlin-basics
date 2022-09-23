import java.util.Scanner

fun main() {
    var balance = readln().toInt()

    val scanner = Scanner(System.`in`)
    while (scanner.hasNextInt()) {
        val price = scanner.next().toInt()

        if (balance - price < 0) {
            return println("Error, insufficient funds for the purchase. Your balance is $balance, but you need $price.")
        } else {
            balance -= price
        }
    }

    println("Thank you for choosing us to manage your account! Your balance is $balance.")
}
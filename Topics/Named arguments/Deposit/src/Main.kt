import kotlin.math.pow

fun compoundInterest(startingAmount: Int = 1000, yearlyPercent: Int = 5, years: Int = 10): Double =
    startingAmount * (1 + yearlyPercent / 100.0).pow(years)

fun main() {
    val parameter = readln()
    val argument = readln().toInt()

    when (parameter) {
        "amount" -> println(compoundInterest(startingAmount = argument).toInt())
        "percent" -> println(compoundInterest(yearlyPercent = argument).toInt())
        "years" -> println(compoundInterest(years = argument).toInt())
    }
}

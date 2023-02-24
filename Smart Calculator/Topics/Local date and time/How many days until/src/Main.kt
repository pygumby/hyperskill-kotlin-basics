import kotlinx.datetime.*

fun daysDifference(date1: String, date2: String): Int {
    val localDate1 = date1.toLocalDate()
    val localDate2 = date2.toLocalDate()
    return Math.abs(localDate1.until(localDate2, DateTimeUnit.DAY))
}

fun main() {
    val date1 = readLine()!!
    val date2 = readLine()!!
    println( daysDifference(date1, date2) )
}

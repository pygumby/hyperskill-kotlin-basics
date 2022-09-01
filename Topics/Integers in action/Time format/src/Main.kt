fun main() {
    val totalSeconds = System.currentTimeMillis() / 1000 // dont change this line
    // enter your code
    val timeInSeconds = totalSeconds % 86400
    val hours = timeInSeconds / 3600
    val minutes = timeInSeconds % 3600 / 60
    val seconds = timeInSeconds % 3600 % 60
    println("$hours:$minutes:$seconds")
}

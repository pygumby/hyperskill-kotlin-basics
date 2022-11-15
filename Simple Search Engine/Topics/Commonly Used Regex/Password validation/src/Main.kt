fun main() {
    // write your code here
    val pw = readln()
    if (Regex("[A-Z]+[a-z]+[0-9]+").matches(pw)) {
        println("Password saved")
    } else {
        println("Password is too simple")
    }
}

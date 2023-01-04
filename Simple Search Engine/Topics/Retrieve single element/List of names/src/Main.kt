fun main() {
    val list: List<String> = readln().split(" ")
    // write your code here
    val res = list.find { it.startsWith("j") && it.endsWith("e") }

    println(res)
}

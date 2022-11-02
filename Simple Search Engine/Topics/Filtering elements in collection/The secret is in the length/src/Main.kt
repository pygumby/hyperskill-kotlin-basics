fun main() {
    val list = readln().split(" ")
    // write your code here
    val res = list.filterIndexed { i, s -> i > 0 && s.length == 5 }

    println(res)
}

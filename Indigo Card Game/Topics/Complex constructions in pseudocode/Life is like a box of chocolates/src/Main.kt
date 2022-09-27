fun reggae(n: Int, k: Int) {
    for (i in 1..n) {
        for (j in 1..n) {
            if ((i + j).mod(k) == 1) {
                print("*")
            } else {
                print("o")
            }
        }
        println()
    }
}

fun main(args: Array<String>) {
    reggae(5, 2)
}

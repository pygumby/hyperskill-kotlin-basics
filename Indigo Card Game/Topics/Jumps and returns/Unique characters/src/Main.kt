fun main() {
    val s = readln()
    val m = mutableMapOf<Char, Int>()

    for (ch in s) {
        if (m.containsKey(ch)) {
            m[ch] = m.getValue(ch) + 1
        } else {
            m[ch] = 1
        }
    }

    println(m.filter { it.value == 1 }.count())
}

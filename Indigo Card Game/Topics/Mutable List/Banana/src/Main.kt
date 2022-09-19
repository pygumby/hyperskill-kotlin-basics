fun solution(strings: MutableList<String>, str: String): MutableList<String> =
    strings.map { s -> if (s == str) "Banana" else s }.toMutableList()

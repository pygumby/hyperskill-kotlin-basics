fun main() {
    for (ch in readln()) {
        if (ch.digitToIntOrNull() == null) {
            continue
        } else {
            return println(ch)
        }
    }
}

fun main() {
    val title = readln()

    // Write your scope function here
    with(title) {
        println(if (this.length > 15) {
            "Our long song: $this".uppercase()
        } else {
            "Our short song: $this".lowercase()
        })
    }
}

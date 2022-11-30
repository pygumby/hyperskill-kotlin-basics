class BiggerBox() {
    class InnerBox<T>(var items: List<T>) {
        fun getSomethingFromBox(): List<T> {
            return items
        }
    }
}

typealias Box<T> = BiggerBox.InnerBox<T>

fun main() {
    var box = Box(listOf("lion", "rose"))
    println(box.getSomethingFromBox().size)
}

class Book(val title: String, val author: String, val price: Double)

fun main() {
    val books = listOf(
        Book("The Great Gatsby", "F. Scott Fitzgerald", 12.99),
        Book("To Kill a Mockingbird", "Harper Lee", 10.99),
        Book("1984", "George Orwell", 8.99),
        Book("The Catcher in the Rye", "J.D. Salinger", 9.99)
    )

    val sortedBooks = books.sortedWith { b1, b2 ->
        if (b1.price < b2.price) {
            -1
        } else if (b1.price == b2.price) {
            0
        } else {
            1
        }
    }

    sortedBooks.forEach { println("${it.title} - ${it.author} - ${it.price}") }
}

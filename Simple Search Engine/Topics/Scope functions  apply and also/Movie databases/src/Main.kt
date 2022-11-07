data class Movie(
    var name: String = "The Knack ...and How to Get It",
    var link: String = "https://",
    var dataBaseName: String = "IMDB"
)

fun main() {
    val movie = Movie()
        .apply {
            val input = readln().split(" ")
            this.dataBaseName = input[0]
            this.link = input[1]
        }
    print(movie)
}

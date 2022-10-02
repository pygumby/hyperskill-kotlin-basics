package indigo

class Deck {
    private var cards = listOf<Card>()

    init {
        this.reset()
        this.shuffle()
    }

    private fun reset() {
        this.cards = Rank.values()
            .map { rank -> Suit.values().map { Card(rank, it) } }
            .flatten()
    }

    private fun shuffle() {
        this.cards = this.cards.shuffled()
    }

    fun draw(n: Int): List<Card> {
        return when (n) {
            !in 1 .. 52 -> throw Exception("Invalid number of cards.")
            !in 1 .. this.cards.size -> throw Exception("The remaining cards are insufficient to meet the request.")
            else -> {
                val drawnCards = this.cards.slice(0 until n)
                if (n <= this.cards.lastIndex) {
                    this.cards = this.cards.slice(n .. this.cards.lastIndex)
                } else {
                    this.cards = emptyList<Card>()
                }
                drawnCards
            }
        }
    }
}

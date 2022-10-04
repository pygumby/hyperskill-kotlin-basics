package indigo

enum class Rank(val symbol: String) {
    ACE("A"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("J"),
    QUEEN("Q"),
    KING("K"),
}

enum class Suit(val symbol: String) {
    HEARTS("♥"),
    CLUBS("♣"),
    SPADES("♠"),
    DIAMONDS("♦"),
}

class Card(val rank: Rank, val suit: Suit) {
    fun hasSameSuitOrRank(card: Card) = this.rank == card.rank || this.suit == card.suit

    override fun toString(): String = "${rank.symbol}${suit.symbol}"
}

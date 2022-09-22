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

class Card(private val rank: Rank, private val suit: Suit) {
    override fun toString(): String = "${rank.symbol}${suit.symbol}"
}

class Deck {
    private var cards = listOf<Card>()

    fun reset() {
        this.cards = Rank.values()
            .map { rank -> Suit.values().map { Card(rank, it) } }
            .flatten()
        println("Card deck is reset.")
    }

    fun shuffle() {
        this.cards = this.cards.shuffled()
        println("Card deck is shuffled.")
    }

    fun get(numberOfCards: String) {
        when (val n = numberOfCards.toIntOrNull()) {
            null -> return println("Invalid number of cards.")
            !in 1 .. 52 -> return println("Invalid number of cards.")
            !in 1 .. this.cards.size -> return println("The remaining cards are insufficient to meet the request.")
            else -> {
                println(this.cards.slice(0 until n).joinToString(" "))
                this.cards = this.cards.slice(n .. this.cards.lastIndex)
            }
        }
    }
}

class Game {
    private val deck = Deck()

    fun promptAction() {
        println("Choose an action (reset, shuffle, get, exit):")

        val action = readln()
        if (action == "exit") return println("Bye")
        when (action) {
            "reset" -> this.deck.reset()
            "shuffle" -> this.deck.shuffle()
            "get" -> {
                println("Number of cards:")
                this.deck.get(readln())
            }
            else -> println("Wrong action.")
        }

        promptAction()
    }
}

fun main() {
    val game = Game()
    game.promptAction()
}

package indigo

abstract class Player {
    var cardsWon = setOf<Card>()
        private set

    protected val cardsOnHand = ArrayDeque<Card>()

    fun hasCardsOnHand() = !this.cardsOnHand.isEmpty()

    fun drawCards(n: Int, deck: Deck) = this.cardsOnHand.addAll(deck.drawCards(n))

    fun winCards(cards: Collection<Card>, silently: Boolean = false) {
        this.cardsWon += cards
        if (!silently) this.printWinCardsMessage()
    }

    fun playCard(cardOnTop: Card?): Card {
        val chosenCardIndex = this.chooseCardToPlay(cardOnTop)
        val chosenCard = this.cardsOnHand[chosenCardIndex]
        this.cardsOnHand.removeAt(chosenCardIndex)
        return chosenCard
    }

    protected abstract fun chooseCardToPlay(cardOnTop: Card?): Int
    protected abstract fun printWinCardsMessage()
}

class HumanPlayer : Player() {
    override fun chooseCardToPlay(cardOnTop: Card?): Int {
        println("Cards in hand: ${this.cardsOnHand.mapIndexed() { i, card -> "${i + 1})$card" }.joinToString(" ")}")
        return this.promptCardIndex()
    }

    override fun printWinCardsMessage() {
        println("Player wins cards")
    }

    private fun promptCardIndex(): Int {
        println("Choose a card to play (1-${this.cardsOnHand.size}):")

        val userInput = readln()
        if (userInput == "exit") {
            println("Game Over")
            kotlin.system.exitProcess(0)
        }

        val userInputInt = userInput.toIntOrNull()
        return if (userInputInt == null || userInputInt !in 1..this.cardsOnHand.size) {
            this.promptCardIndex()
        } else {
            userInputInt - 1
        }
    }
}

class ComputerPlayer(private val strategy: Strategy) : Player() {
    override fun chooseCardToPlay(cardOnTop: Card?): Int {
        println(this.cardsOnHand.joinToString(" "))
        val chosenCardIndex = this.strategy.getBestCard(this.cardsOnHand, cardOnTop)
        println("Computer plays ${this.cardsOnHand[chosenCardIndex]}")
        return chosenCardIndex
    }

    override fun printWinCardsMessage() {
        println("Computer wins cards")
    }
}

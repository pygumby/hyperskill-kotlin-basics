package indigo

abstract class Player {
    var cardsWon = setOf<Card>()
        private set

    protected var cardsOnHand = ArrayDeque<Card>()

    protected abstract fun pickCardIndex(): Int
    protected abstract fun printWinCardsMessage()

    fun hasCardsOnHand() = !this.cardsOnHand.isEmpty()

    fun drawCards(n: Int, deck: Deck) = this.cardsOnHand.addAll(deck.drawCards(n))

    fun playTurn(): Card {
        val chosenCardIndex = this.pickCardIndex()
        val chosenCard = this.cardsOnHand[chosenCardIndex]
        this.cardsOnHand.removeAt(chosenCardIndex)
        return chosenCard
    }

    fun winCards(cards: Collection<Card>, silently: Boolean = false) {
        this.cardsWon += cards
        if (!silently) this.printWinCardsMessage()
    }
}

class HumanPlayer : Player() {
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

    override fun pickCardIndex(): Int {
        println("Cards in hand: ${this.cardsOnHand.mapIndexed() { i, card -> "${i + 1})$card" }.joinToString(" ")}")
        return this.promptCardIndex()
    }

    override fun printWinCardsMessage() {
        println("Player wins cards")
    }
}

class ComputerPlayer : Player() {
    override fun pickCardIndex(): Int {
        val chosenCardIndex = (0 until this.cardsOnHand.size).random()
        println("Computer plays ${this.cardsOnHand[chosenCardIndex]}")
        return chosenCardIndex
    }

    override fun printWinCardsMessage() {
        println("Computer wins cards")
    }
}

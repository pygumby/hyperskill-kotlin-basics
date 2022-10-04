package indigo

abstract class Player(private val deck: Deck) {
    protected var cardsOnHand = ArrayDeque<Card>()
        get() {
            if (field.isEmpty()) field.addAll(this.deck.draw(6))
            return field
        }

    protected abstract fun pickCardIndex(): Int

    fun playTurn(): Card {
        val chosenCardIndex = this.pickCardIndex()
        val chosenCard = this.cardsOnHand[chosenCardIndex]
        this.cardsOnHand.removeAt(chosenCardIndex)
        return chosenCard
    }
}

class HumanPlayer(deck: Deck) : Player(deck) {
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
}

class ComputerPlayer(deck: Deck) : Player(deck) {
    override fun pickCardIndex(): Int {
        val chosenCardIndex = (0 until this.cardsOnHand.size).random()
        println("Computer plays ${this.cardsOnHand[chosenCardIndex]}")
        return chosenCardIndex
    }
}
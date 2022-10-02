package indigo

import kotlin.system.exitProcess

class Game() {
    private val deck = Deck()
    private val stack = ArrayDeque<Card>()
    private val playersHand = ArrayDeque<Card>()
    private val computersHand = ArrayDeque<Card>()

    private var playersTurn = true

    private fun promptPlayFirst() {
        println("Play first?")
        val playFirst = readln().lowercase()

        return if (playFirst == "yes" || playFirst == "no") {
            this.playersTurn = playFirst == "yes"
        } else {
            promptPlayFirst()
        }
    }

    private fun promptCardNumber(max: Int): Int {
        println("Choose a card to play (1-$max):")

        val userInput = readln()

        if (userInput == "exit") {
            println("Game Over")
            exitProcess(0)
        }

        return when (val n = userInput.toIntOrNull()) {
            null -> promptCardNumber(max)
            in 1..max -> n
            else -> promptCardNumber(max)
        }
    }

    private fun runGameLoop() {
        println("${this.stack.size} cards on the table, and the top card is ${this.stack.last()}")
        if (this.stack.size == 52) return println("Game Over")

        if (this.playersTurn) {
            if (this.playersHand.isEmpty()) this.playersHand.addAll(this.deck.draw(6))

            val playersHandFormatted = this.playersHand.mapIndexed() { i, card -> "${i + 1})$card" }
            println("Cards in hand: ${playersHandFormatted.joinToString(" ")}")
            val chosenCardIndex = this.promptCardNumber(this.playersHand.size) - 1
            this.stack.addLast(this.playersHand[chosenCardIndex])
            this.playersHand.removeAt(chosenCardIndex)

            this.playersTurn = false
        } else {
            if (this.computersHand.isEmpty()) this.computersHand.addAll(this.deck.draw(6))

            val chosenCardIndex = (0 until this.computersHand.size).random()
            println("Computer plays ${this.computersHand[chosenCardIndex]}")
            this.stack.addLast(this.computersHand[chosenCardIndex])
            this.computersHand.removeAt(chosenCardIndex)

            this.playersTurn = true
        }

        println()
        runGameLoop()
    }

    fun start() {
        println("Indigo Card Game")
        promptPlayFirst()

        this.stack.addAll(this.deck.draw(4))
        println("Initial cards on the table: ${this.stack.joinToString(" ")}")

        println()
        runGameLoop()
    }
}

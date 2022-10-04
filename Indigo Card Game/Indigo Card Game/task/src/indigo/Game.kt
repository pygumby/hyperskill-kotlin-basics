package indigo

class Game {
    private val deck = Deck()
    private val cardsOnTable = ArrayDeque<Card>()

    private val humanPlayer = HumanPlayer(this.deck)
    private val computerPlayer = ComputerPlayer(this.deck)

    private var currentPlayer: Player = this.humanPlayer

    private fun promptPlayFirst() {
        println("Play first?")

        return when(readln().lowercase()) {
            "yes" -> return
            "no" -> this.currentPlayer = this.computerPlayer
            else -> promptPlayFirst()
        }
    }

    private fun runGameLoop() {
        println("${this.cardsOnTable.size} cards on the table, and the top card is ${this.cardsOnTable.last()}")

        if (this.cardsOnTable.size == 52) return println("Game Over")

        val playedCard = this.currentPlayer.playTurn()
        this.cardsOnTable.addLast(playedCard)

        this.currentPlayer = if (this.currentPlayer == this.humanPlayer) this.computerPlayer else this.humanPlayer

        println()
        runGameLoop()
    }

    fun start() {
        println("Indigo Card Game")
        this.promptPlayFirst()

        this.cardsOnTable.addAll(this.deck.draw(4))
        println("Initial cards on the table: ${this.cardsOnTable.joinToString(" ")}")

        println()
        runGameLoop()
    }
}

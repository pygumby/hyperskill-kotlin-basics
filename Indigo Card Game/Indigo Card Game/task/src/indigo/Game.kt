package indigo

class Game {
    private val deck = Deck()
    private val cardsOnTable = ArrayDeque<Card>()

    private val humanPlayer = HumanPlayer()
    private val computerPlayer = ComputerPlayer(BasicStrategy())

    private var currentPlayer: Player = this.humanPlayer
    private var startingPlayer: Player = this.humanPlayer
    private var lastWinningPlayer: Player? = null

    private fun promptPlayFirst() {
        println("Play first?")

        return when(readln().lowercase()) {
            "yes" -> return
            "no" -> {
                this.currentPlayer = this.computerPlayer
                this.startingPlayer = this.computerPlayer
            }
            else -> promptPlayFirst()
        }
    }

    private fun printScore(hasGameEnded: Boolean = false) {
        val humanPlayersWonCards = this.humanPlayer.cardsWon
        val computerPlayersWonCards = this.computerPlayer.cardsWon

        val winningRanks = setOf(Rank.ACE, Rank.TEN, Rank.JACK, Rank.QUEEN, Rank.KING)
        var humanPlayersScore = humanPlayersWonCards.count { it.rank in winningRanks }
        var computerPlayersScore = computerPlayersWonCards.count { it.rank in winningRanks }

        if (hasGameEnded) {
            if (humanPlayersWonCards.size > computerPlayersWonCards.size) {
                humanPlayersScore += 3
            } else if (humanPlayersWonCards.size < computerPlayersWonCards.size) {
                computerPlayersScore += 3
            } else {
                if (this.startingPlayer == this.humanPlayer) humanPlayersScore += 3 else computerPlayersScore += 3
            }
        }

        println("Score: Player $humanPlayersScore - Computer $computerPlayersScore")
        println("Cards: Player ${humanPlayersWonCards.size} - Computer ${computerPlayersWonCards.size}")
    }

    private fun runGameLoop() {
        if (this.cardsOnTable.isEmpty()) {
            println("No cards on the table")
        } else {
            println("${this.cardsOnTable.size} cards on the table, and the top card is ${this.cardsOnTable.last()}")
        }

        if (this.deck.isEmpty() && !this.currentPlayer.hasCardsOnHand()) {
            this.lastWinningPlayer?.winCards(this.cardsOnTable, silently = true) ?:
                    this.startingPlayer.winCards(this.cardsOnTable, silently = true)
            this.printScore(hasGameEnded = true)
            return println("Game Over")
        }

        if (!this.currentPlayer.hasCardsOnHand()) this.currentPlayer.drawCards(6, this.deck)

        val playedCard = this.currentPlayer.playCard(this.cardsOnTable.lastOrNull())
        if (!this.cardsOnTable.isEmpty() && playedCard.hasSameRankOrSuit(this.cardsOnTable.last())) {
            this.currentPlayer.winCards(this.cardsOnTable.plus(playedCard))
            this.lastWinningPlayer = this.currentPlayer
            this.cardsOnTable.clear()
            this.printScore()
        } else {
            this.cardsOnTable.addLast(playedCard)
        }

        this.currentPlayer = if (this.currentPlayer == this.humanPlayer) this.computerPlayer else this.humanPlayer

        println()
        runGameLoop()
    }

    fun start() {
        println("Indigo Card Game")
        this.promptPlayFirst()

        this.cardsOnTable.addAll(this.deck.drawCards(4))
        println("Initial cards on the table: ${this.cardsOnTable.joinToString(" ")}\n")

        runGameLoop()
    }
}

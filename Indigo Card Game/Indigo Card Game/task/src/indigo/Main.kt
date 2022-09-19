package indigo

val RANKS = listOf("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")
val SUITS = listOf("♦", "♥", "♠", "♣")
val DECK = RANKS.map { rank ->  SUITS.map { suit -> rank + suit } }.flatten()

fun main() {
    println(RANKS.joinToString(" "))
    println(SUITS.joinToString(" "))
    println(DECK.joinToString(" "))
}

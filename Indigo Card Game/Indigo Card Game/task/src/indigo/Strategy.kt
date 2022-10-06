package indigo

interface Strategy {
    fun getBestCard(cardsOnHand: ArrayDeque<Card>, cardOnTop: Card?): Int
}

class BasicStrategy : Strategy {
    private fun getDuplicateCard(cards: List<Pair<Int, Card>>): Int? {
        val sameSuit = cards.groupBy { it.second.suit }.filter { it.value.size > 1 }
        if (sameSuit.isNotEmpty()) return sameSuit.values.first().first().first

        val sameRank = cards.groupBy { it.second.rank }.filter { it.value.size > 1 }
        if (sameRank.isNotEmpty()) return sameRank.values.first().first().first

        return null
    }

    override fun getBestCard(cardsOnHand: ArrayDeque<Card>, cardOnTop: Card?): Int {
        if (cardsOnHand.size == 1) return 0
        if (cardOnTop == null) return getDuplicateCard(cardsOnHand.mapIndexed { i, card -> i to card }) ?: 0

        val candidateCards = cardsOnHand
            .mapIndexed { i, card -> i to card }
            .filter { it.second.hasSameRankOrSuit(cardOnTop) }

        if (candidateCards.size == 1) return candidateCards.first().first
        if (candidateCards.isEmpty()) return getDuplicateCard(cardsOnHand.mapIndexed { i, card -> i to card }) ?: 0

        return getDuplicateCard(candidateCards.filter { it.second.hasSameSuit(cardOnTop) }) ?:
                getDuplicateCard(candidateCards.filter { it.second.hasSameRank(cardOnTop) }) ?:
                candidateCards.first().first
    }
}

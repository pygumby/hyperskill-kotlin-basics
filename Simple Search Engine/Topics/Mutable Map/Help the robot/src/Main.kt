fun helpingTheRobot(purchases: Map<String, Int>, addition: Map<String, Int>) : MutableMap<String, Int> {
    val newPurchases = purchases.toMutableMap()

    for ((item, qty) in addition) {
        newPurchases[item] = (purchases[item] ?: 0) + qty
    }

    return newPurchases
}

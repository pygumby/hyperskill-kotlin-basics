fun isReversed(pair: Pair<String, String>): Triple<String, String, Boolean> =
    Triple(
        pair.first,
        pair.second,
        pair.second.lowercase().reversed() == pair.first.lowercase()
    )

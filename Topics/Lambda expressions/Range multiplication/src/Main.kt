val lambda: (Long, Long) -> Long = { l1, l2 ->
    var product = l1
    for (l in l1 + 1..l2) {
      product *= l
    }
    product
}

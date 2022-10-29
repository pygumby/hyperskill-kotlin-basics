fun evenFilter(numbers: Set<Int>): Set<Int> =
    numbers.filter { it % 2 == 0 }.toSet()

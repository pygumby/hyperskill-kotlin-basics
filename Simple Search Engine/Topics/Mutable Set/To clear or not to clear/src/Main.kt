fun solution(elements: MutableSet<Int>, element: Int): MutableSet<Int> =
    if (elements.contains(element)) {
        mutableSetOf<Int>()
    } else {
        elements
    }

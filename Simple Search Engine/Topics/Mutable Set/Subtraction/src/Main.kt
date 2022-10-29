fun solution(elements: Set<String>, element: String): MutableSet<String> =
    (elements - element).toMutableSet()

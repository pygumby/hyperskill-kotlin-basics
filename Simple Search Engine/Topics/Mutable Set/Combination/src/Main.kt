fun solution(setSource: Set<String>, listSource: MutableList<String>): MutableSet<String> =
    (setSource.toMutableSet() + listSource.toMutableSet()).toMutableSet()

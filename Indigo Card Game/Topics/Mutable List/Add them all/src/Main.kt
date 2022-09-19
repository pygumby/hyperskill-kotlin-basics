fun solution(first: List<Int>, second: List<Int>): MutableList<Int> {
    val mutableFirst = first.toMutableList()
    mutableFirst.addAll(second)
    return mutableFirst
}

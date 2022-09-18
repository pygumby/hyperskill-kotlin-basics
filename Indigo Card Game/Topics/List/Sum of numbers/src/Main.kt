fun solution(numbers: List<Int>): Int =
    numbers.fold(0) { acc, n -> acc + n }

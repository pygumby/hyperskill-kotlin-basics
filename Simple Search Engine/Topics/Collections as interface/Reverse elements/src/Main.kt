// Write function addElements() here
fun <E> addElements(elems: Collection<E>) =
    elems.reversed()


fun main() {
    val originalList = readln().split(" ").map { it }.toMutableList()
    val originalSet = originalList.toMutableSet()

    println(addElements(originalList))
    println(addElements(originalSet))
}

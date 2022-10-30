// Write here function addListToCollection()
fun addListToCollection(s1: MutableCollection<String>, s2: Collection<String>) =
    s1.addAll(s2)

fun main() {
    val oldList = readln().split(" ").toMutableList()
    val oldSet = oldList.toMutableSet()
    val addedList = readln().split(" ").toList()

    addListToCollection(oldList, addedList)
    addListToCollection(oldSet, addedList)

    println(oldList.joinToString(" "))
    println(oldSet.joinToString(" "))
}

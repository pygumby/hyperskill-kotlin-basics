// implement your function here
fun <T> countItem(list: List<T>, item: T) =
    list.count { it == item }

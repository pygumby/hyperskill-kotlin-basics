class ListStorageIterator(private val workTeam: ListStorage) : Iterator<StoredNode> {
    lateinit var current: StoredNode
    private var isAccessed: Boolean = false

    override fun hasNext(): Boolean {
        if (!this.isAccessed) this.current = this.workTeam.head
        return this.current.next != null
    }

    override fun next(): StoredNode {
        if (!this.isAccessed) {
            this.current = this.workTeam.head
            this.isAccessed = true
        } else {
            if (this.current.next == null) throw NoSuchElementException()
            this.current = this.current.next!!
        }
        return this.current
    }
}

fun main() {
    // don't change this code
    val listStorage = ListStorage(StoredNode("Nik", 30))
    listStorage.add(StoredNode("Sofi", 25))
    listStorage.add(StoredNode("Mike", 45))
    val iterStorage = listStorage.iterator()
    while (iterStorage.hasNext()){
        println(iterStorage.next().toNodeString())
    }
}

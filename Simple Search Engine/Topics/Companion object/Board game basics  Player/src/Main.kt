class Player(val id: Int, val name: String, val hp: Int) {
    companion object {
        private var numberOfPlayers = 0
        private const val defaultHp = 100

        fun create(name: String): Player {
            this.numberOfPlayers += 1
            return Player(this.numberOfPlayers, name, this.defaultHp)
        }
    }
}

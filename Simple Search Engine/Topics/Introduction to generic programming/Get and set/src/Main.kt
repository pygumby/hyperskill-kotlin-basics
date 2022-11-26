data class QuizBox<T>(val hiddenItem: T) {
    var isChanged = false
    var item: T = this.hiddenItem
        // implement methods
        get() {
            println("You asked for the item")
            return field
        }
        set(value) {
            this.isChanged = true
            println("You changed the item")
            field = value
        }
}

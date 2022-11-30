// correct the code line below
typealias Snake = Pet.Reptile.Snake

// don't change the code below!
class Pet {
    class Reptile {
        data class Snake(val str: String) {
            val sound = str
        }
    }
}

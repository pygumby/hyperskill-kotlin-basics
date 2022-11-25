interface Weight {
    fun getWeight(): Int
    fun affectedByGravity(): Boolean
}

interface Form {
    fun getVolume(): Int
}

class HeavyBrick : Weight, Form {
    override fun getWeight(): Int = 50
    override fun affectedByGravity(): Boolean = true
    override fun getVolume(): Int = 20
}

class HeavyBrickComposition : Weight by Heavy, Form by Brick

// Do not change the code above.

object Heavy : Weight {
    override fun getWeight(): Int = 50
    override fun affectedByGravity(): Boolean = true
}

object Brick : Form {
    override fun getVolume(): Int = 20
}

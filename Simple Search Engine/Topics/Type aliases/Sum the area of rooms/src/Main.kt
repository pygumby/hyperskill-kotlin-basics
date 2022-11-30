class John {
    class JohnApartment(sizeOfRoom: Int) {
        val size: Int = sizeOfRoom
    }
}

class Nick {
    class NickApartment(sizeOfRoom: Int) {
        val size: Int = sizeOfRoom
    }
}

typealias JohnArea = John.JohnApartment
typealias NickArea = Nick.NickApartment

fun findTotalArea(): Int {
    // return the total area
    val johnArea = JohnArea(40).size
    val nickArea = NickArea(60).size

    return johnArea + nickArea
}

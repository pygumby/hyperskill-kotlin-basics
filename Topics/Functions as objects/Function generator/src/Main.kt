fun identity(x: Int) = x
fun half(i: Int) = i / 2
fun zero(i: Int) = 0

fun generate(functionName: String): (Int) -> Int = when (functionName) {
    "identity" -> ::identity
    "half" -> ::half
    else -> ::zero
}

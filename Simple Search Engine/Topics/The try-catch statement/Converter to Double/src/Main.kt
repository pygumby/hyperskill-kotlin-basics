import java.lang.Exception

/**
 * It returns a double value or 0 if an exception occurred
 */
fun convertStringToDouble(input: String): Double =
    try {
        input.toDouble()
    } catch (_: Exception) {
        0.0
    }

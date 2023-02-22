fun main() {
    val intValues = mapOf(
        java.util.logging.Level.SEVERE.name to java.util.logging.Level.SEVERE.intValue(),
        java.util.logging.Level.WARNING.name to java.util.logging.Level.WARNING.intValue(),
        java.util.logging.Level.INFO.name to java.util.logging.Level.INFO.intValue(),
        java.util.logging.Level.CONFIG.name to java.util.logging.Level.CONFIG.intValue(),
        java.util.logging.Level.FINE.name to java.util.logging.Level.FINE.intValue(),
        java.util.logging.Level.FINER.name to java.util.logging.Level.FINER.intValue(),
        java.util.logging.Level.FINEST.name to java.util.logging.Level.FINEST.intValue(),
    )

    println(readln()
        .split(" ")
        .map { intValues[it.uppercase()] }
        .fold(0) { a, b -> a + b!! }
    )
}

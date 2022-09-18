// Version that works in the IDE
/* import java.io.File

fun main() {
    val text = readln()

    val workingDirectory = System.getProperty("user.dir") // Configured to point to "Version Control System"
    val fileName = "MyFile.txt"
    val s = File.separator

    val file = File("$workingDirectory${s}Topics${s}Writing files${s}Duplication$s$fileName")
    file.writeText(text + text)

    println(file.readText())
} */

// Version that is accepted by Hyperskill
val text = readln()
val myFile = File("MyFile.txt")

myFile.writeText(text)
myFile.appendText(text)

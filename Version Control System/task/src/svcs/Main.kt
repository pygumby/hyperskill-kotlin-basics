package svcs

fun main(args: Array<String>) {
    val helpConfig = "Get and set a username."
    val helpAdd = "Add a file to the index."
    val helpLog = "Show commit logs."
    val helpCommit = "Save changes."
    val helpCheckout = "Restore a file."

    fun printHelpAll() = println("""
        These are SVCS commands:
        config     $helpConfig
        add        $helpAdd
        log       $helpLog
        commit     $helpCommit
        checkout   $helpCheckout
    """.trimIndent())

    if (args.isEmpty()) return printHelpAll()

    when (val arg = args.first()) {
        "--help"   -> printHelpAll()
        "config"   -> println(helpConfig)
        "add"      -> println(helpAdd)
        "log"      -> println(helpLog)
        "commit"   -> println(helpCommit)
        "checkout" -> println(helpCheckout)
        else       -> println("'$arg' is not a SVCS command.")
    }
}

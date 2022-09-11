package svcs

import java.io.File

fun help(arg: String = "--help"): Unit {
    val config = "Get and set a username."
    val add = "Add a file to the index."
    val log = "Show commit logs."
    val commit = "Save changes."
    val checkout = "Restore a file."
    val all = """
        These are SVCS commands:
        config     $config
        add        $add
        log        $log
        commit     $commit
        checkout   $checkout
    """.trimIndent()

    when (arg) {
        "config" -> println(config)
        "add" -> println(add)
        "log" -> println(log)
        "commit" -> println(commit)
        "checkout" -> println(checkout)
        "--help" -> println(all)
    }
}

enum class VcsFile {
    VCS_DIR,
    CONFIG_TXT,
    INDEX_TXT
}

fun getVcsFile(vcsFile: VcsFile): File {
    val s = File.separator
    return when (vcsFile) {
        VcsFile.VCS_DIR -> File("vcs")
        VcsFile.CONFIG_TXT -> File("vcs${File.separator}config.txt")
        VcsFile.INDEX_TXT -> File("vcs${File.separator}index.txt")
    }
}

fun validateVcsDir() {
    val vcsDir = getVcsFile(VcsFile.VCS_DIR)
    val configFile = getVcsFile(VcsFile.CONFIG_TXT)
    val indexFile = getVcsFile(VcsFile.INDEX_TXT)

    if (vcsDir.exists()) {
        if (!configFile.exists()) configFile.createNewFile()
        if (!indexFile.exists()) indexFile.createNewFile()
    } else {
        vcsDir.mkdir()
        configFile.createNewFile()
        indexFile.createNewFile()
    }
}

fun config(userName: String?): Unit {
    validateVcsDir()

    val configFile = getVcsFile(VcsFile.CONFIG_TXT)

    if (userName == null) {
        val configFileText = configFile.readText()

        if (configFileText.isEmpty()) {
            println("Please, tell me who you are.")
        } else {
            println("The username is $configFileText.")
        }
    } else {
        configFile.writeText(userName)
        println("The username is ${configFile.readText()}.")
    }
}

fun add(fileName: String?): Unit {
    validateVcsDir()

    val indexFile = getVcsFile(VcsFile.INDEX_TXT)

    if (fileName == null) {
        val indexFileText = indexFile.readText()

        if (indexFileText.isEmpty()) {
            println("Add a file to the index.")
        } else {
            println("Tracked files:\n$indexFileText")
        }
    } else {
        if (File(fileName).exists()) {
            indexFile.appendText("$fileName\n")
            println("The file '$fileName' is tracked.")
        } else {
            println("Can't find '$fileName'.")
        }
    }
}

fun main(args: Array<String>): Unit {
    if (args.isEmpty()) return help()
    when (args[0]) {
        "config" -> config(args.elementAtOrNull(1))
        "add" -> add(args.elementAtOrNull(1))
        "log" -> help(args[0])
        "commit" -> help(args[0])
        "checkout" -> help(args[0])
        "--help" -> help(args[0])
        else -> println("'${args[0]}' is not a SVCS command.")
    }
}

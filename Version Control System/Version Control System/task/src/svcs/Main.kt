package svcs

import java.io.File
import java.security.MessageDigest
import java.time.LocalDateTime

fun help(arg: String) {
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
    COMMITS_DIR,
    CONFIG_TXT,
    INDEX_TXT,
    LOG_TXT,
}

fun getVcsFile(vcsFile: VcsFile): File = when (vcsFile) {
    VcsFile.VCS_DIR -> File("vcs")
    VcsFile.COMMITS_DIR -> File("vcs${File.separator}commits")
    VcsFile.CONFIG_TXT -> File("vcs${File.separator}config.txt")
    VcsFile.INDEX_TXT -> File("vcs${File.separator}index.txt")
    VcsFile.LOG_TXT -> File("vcs${File.separator}log.txt")
}

fun getAddedFilesNames(): List<String> =
    getVcsFile(VcsFile.INDEX_TXT).readText().split("\n").filter { it != "" }

fun validateVcsDir() {
    val vcsDir = getVcsFile(VcsFile.VCS_DIR)
    val commitDir = getVcsFile(VcsFile.COMMITS_DIR)
    val configFile = getVcsFile(VcsFile.CONFIG_TXT)
    val indexFile = getVcsFile(VcsFile.INDEX_TXT)
    val logFile = getVcsFile(VcsFile.LOG_TXT)

    if (!getVcsFile(VcsFile.VCS_DIR).exists()) vcsDir.mkdir()
    if (!commitDir.exists()) commitDir.mkdir()
    if (!configFile.exists()) configFile.createNewFile()
    if (!indexFile.exists()) indexFile.createNewFile()
    if (!logFile.exists()) logFile.createNewFile()
}

fun config(userName: String?) {
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

fun add(fileName: String?) {
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

fun log() {
    validateVcsDir()

    val logFile = getVcsFile(VcsFile.LOG_TXT)
    val logFileText = logFile.readText()

    if (logFileText.isEmpty()) {
        println("No commits yet.")
    } else {
        println(logFileText)
    }
}

fun commit(message: String?) {
    fun getHash(s: String): String {
        val sha256 = MessageDigest.getInstance("SHA-256")
        val hash = sha256.digest(s.toByteArray())
        return hash.fold("") { acc, b -> acc + "%02x".format(b) }
    }

    fun haveFilesChanged(addedFilesNames: List<String>): Boolean {
        val logFileFirstLine = getVcsFile(VcsFile.LOG_TXT).useLines { it.firstOrNull() }
        val lastCommitId = if (logFileFirstLine == null) null else logFileFirstLine.split(" ")[1]
        val commitsDirPath = getVcsFile(VcsFile.COMMITS_DIR).path

        return lastCommitId == null || addedFilesNames.any { addedFileName ->
            val addedFile = File(addedFileName)
            val addedFileHash = getHash(addedFile.readText())
            val lastCommittedFile = File("$commitsDirPath${File.separator}$lastCommitId${File.separator}$addedFileName")
            val lastCommittedFileHash = getHash(lastCommittedFile.readText())
            addedFileHash != lastCommittedFileHash
        }
    }

    fun logCommit(newCommitId: String) {
        val author = getVcsFile(VcsFile.CONFIG_TXT).readText()
        val commitLog = "commit $newCommitId\nAuthor: $author\n$message\n\n"
        val logFile = getVcsFile(VcsFile.LOG_TXT)
        logFile.writeText(commitLog + logFile.readText())
    }

    validateVcsDir()

    if (message == null) return println("Message was not passed.")

    val addedFilesNames = getAddedFilesNames()
    if (addedFilesNames.isEmpty()) return println("No files were added.")
    if (!haveFilesChanged(addedFilesNames)) return println("Nothing to commit.")

    val commitsDirPath = getVcsFile(VcsFile.COMMITS_DIR).path

    val newCommitId = getHash(LocalDateTime.now().toString() + message)
    val newCommitDir = File("$commitsDirPath${File.separator}$newCommitId")
    newCommitDir.mkdir()

    for (addedFileName in addedFilesNames) {
        val addedFile = File(addedFileName)
        val committedFile = File("$commitsDirPath${File.separator}$newCommitId${File.separator}$addedFileName")
        addedFile.copyTo(committedFile, overwrite = true)
    }

    logCommit(newCommitId)

    println("Changes are committed.")
}

fun checkout(commitId: String?) {
    fun getListOfCommitIds(): List<String> {
        val commitDirs = getVcsFile(VcsFile.COMMITS_DIR).listFiles()
        return commitDirs?.map { it.name } ?: listOf<String>()
    }

    if (commitId == null) return println("Commit id was not passed.")
    if (!getListOfCommitIds().contains(commitId)) return println("Commit does not exist.")

    val addedFilesNames = getAddedFilesNames()
    val commitsDirPath = getVcsFile(VcsFile.COMMITS_DIR).path

    for (addedFileName in addedFilesNames) {
        val addedFile = File(addedFileName)
        val committedFile = File("$commitsDirPath${File.separator}$commitId${File.separator}$addedFileName")
        committedFile.copyTo(addedFile, overwrite = true)
    }

    println("Switched to commit $commitId.")
}

fun main(args: Array<String>) {
    if (args.isEmpty() || args[0] == "--help") return help("--help")
    when (args[0]) {
        "config" -> config(args.elementAtOrNull(1))
        "add" -> add(args.elementAtOrNull(1))
        "log" -> log()
        "commit" -> commit(args.elementAtOrNull(1))
        "checkout" -> checkout(args.elementAtOrNull(1))
        else -> println("'${args[0]}' is not a SVCS command.")
    }
}

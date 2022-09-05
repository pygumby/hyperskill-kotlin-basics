fun main(args: Array<String>) {
    fun printArg(n: Int, arg: String) {
        println("Argument $n: $arg. It has ${arg.length} characters")
    }

    if (args.size != 3) {
        println("Invalid number of program arguments")
    } else {
        printArg(1, args[0])
        printArg(2, args[1])
        printArg(3, args[2])
    }
}

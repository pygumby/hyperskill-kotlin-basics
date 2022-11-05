fun printFifthCharacter(input: String): String =
    try {
        "The fifth character of the entered word is ${input[4]}"
    } catch (_: StringIndexOutOfBoundsException) {
        "The input word is too short!"
    }

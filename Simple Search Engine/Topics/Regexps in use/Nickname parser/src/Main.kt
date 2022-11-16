fun parsingNickname(emailString: String): String {
    val symbolsForNickname = Regex("[._]") // fix this condition
    val nicknameString = emailString.split("@").first() // fix this condition
    val (firstName, lastName) = nicknameString.split(symbolsForNickname).map { it.replaceFirstChar { it.uppercase() } }
    val nickname = "$firstName $lastName" // put your code here
    return nickname
}

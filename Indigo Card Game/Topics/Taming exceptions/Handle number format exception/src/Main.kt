fun parseCardNumber(cardNumber: String): Long {
    if (!Regex("([0-9]{4} ){3}[0-9]{4}").matches(cardNumber)) {
        throw NumberFormatException("A correct card number must contain three spaces ")
    } else {
        return cardNumber.filter { it.isDigit() }.toLong()
    }
}

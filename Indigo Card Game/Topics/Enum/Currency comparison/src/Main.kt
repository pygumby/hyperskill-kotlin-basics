enum class Currency(val fullName: String) {
    EasternCaribbeanDollar("Eastern Caribbean dollar"),
    CanadianDollar("Canadian dollar"),
    Euro("Euro"),
    AustralianDollar("Australian dollar"),
    BrazilianReal("Brazilian real"),
    CfaFranc("CFA franc"),
}

enum class Country(val currency: Currency) {
    Germany(Currency.Euro),
    Mali(Currency.CfaFranc),
    Dominica(Currency.EasternCaribbeanDollar),
    Canada(Currency.CanadianDollar),
    Spain(Currency.Euro),
    Australia(Currency.AustralianDollar),
    Brazil(Currency.BrazilianReal),
    Senegal(Currency.CfaFranc),
    France(Currency.Euro),
    Grenada(Currency.EasternCaribbeanDollar),
    Kiribati(Currency.AustralianDollar),
}

fun findByName(name: String): Country? {
    for (enum in Country.values()) {
        if (name == enum.name) return enum
    }
    return null
}

fun main() {
    val (country1: Country?, country2: Country?) = readln().split(" ").map { findByName(it) }
    return if (country1 == null || country2 == null) {
        println(false)
    } else if (country1.currency == country2.currency) {
        println(true)
    } else {
        println(false)
    }
}

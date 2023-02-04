package calculator

import com.github.h0tk3y.betterParse.combinators.*
import com.github.h0tk3y.betterParse.grammar.Grammar
import com.github.h0tk3y.betterParse.grammar.parseToEnd
// import com.github.h0tk3y.betterParse.grammar.parser
// import com.github.h0tk3y.betterParse.lexer.literalToken
import com.github.h0tk3y.betterParse.lexer.regexToken
import com.github.h0tk3y.betterParse.parser.Parser

// Based on @h0tk3y's example on how to implement an arithmetic parser in `better-parse`:
// https://github.com/h0tk3y/better-parse/blob/master/demo/demo-jvm/src/main/kotlin/com/example/ArithmeticsEvaluator.kt
class CalcGrammar: Grammar<Int>() {
    private val num by regexToken("(-?|\\+?)\\d+")
    // private val lparens by literalToken("(")
    // private val rparens by literalToken(")")
    // private val pow by literalToken("^")
    // private val mul by literalToken("*")
    // private val div by literalToken("/")
    private val plus by regexToken("\\++|(--)+ ")
    private val minus by regexToken("-(--)* ")
    private val ws by regexToken("\\s+", ignore = true)

    private val term: Parser<Int> by
        num use { text.toInt() } // or
        // (skip(minus) and parser(::term) map { -it }) // or
        // (skip(lparens) and parser(::rootParser) and skip(rparens))

    // private val powChain by
        // leftAssociative(term, pow) { a, _, b -> a.toDouble().pow(b.toDouble()).toInt() }

    // private val mulDivChain by
        // leftAssociative(powChain, mul or div use { type }) { a, op, b -> if (op == div) a / b else a * b }

    private val sumSubChain by
        leftAssociative(term /* mulDivChain */, plus or minus use { type }) { a, op, b -> if (op == plus) a + b else a - b }

    override val rootParser by sumSubChain
}

fun main() {
    val input = readln()

    if ((input.startsWith("/"))) {
        when (input.drop(1)) {
            "help" -> println("The program calculates the sum of numbers")
            "exit" -> return println("Bye!")
            else -> println("Unknown command")
        }
    } else {
        if (input == "") return main()
        try {
            println(CalcGrammar().parseToEnd(input))
        } catch (_: Exception) {
            println("Invalid expression")
        }
    }

    main()
}

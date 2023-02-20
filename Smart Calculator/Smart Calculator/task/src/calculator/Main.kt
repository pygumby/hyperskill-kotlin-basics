package calculator

import com.github.h0tk3y.betterParse.combinators.*
import com.github.h0tk3y.betterParse.grammar.Grammar
import com.github.h0tk3y.betterParse.grammar.parseToEnd
import com.github.h0tk3y.betterParse.lexer.literalToken
// import com.github.h0tk3y.betterParse.grammar.parser
// import com.github.h0tk3y.betterParse.lexer.literalToken
import com.github.h0tk3y.betterParse.lexer.regexToken
import com.github.h0tk3y.betterParse.parser.Parser

sealed interface CalcExpression
data class Num(val n: Int): CalcExpression
data class Nme(val s: String): CalcExpression
data class Add(val e1: CalcExpression, val e2: CalcExpression): CalcExpression
data class Sub(val e1: CalcExpression, val e2: CalcExpression): CalcExpression
data class Bnd(val s: String, val e: CalcExpression): CalcExpression

class EvalException(message: String): Exception(message)

fun eval(e: CalcExpression, bnds: Map<String, Int>): Pair<Int?, Map<String, Int>> = when (e) {
    is Num -> e.n to bnds
    is Nme -> if (bnds.containsKey(e.s)) bnds[e.s] to bnds else throw EvalException("Unknown variable")
    is Add -> eval(e.e1, bnds).first!! + eval(e.e2, bnds).first!! to bnds
    is Sub -> eval(e.e1, bnds).first!! - eval(e.e2, bnds).first!! to bnds
    is Bnd -> null to bnds + (e.s to eval(e.e, bnds).first!!)
}

// Based on @h0tk3y's example on how to implement an arithmetic parser using the `better-parse` library:
// https://github.com/h0tk3y/better-parse/blob/master/demo/demo-jvm/src/main/kotlin/com/example/ArithmeticsEvaluator.kt
// The `better-parse` library has been added as a dependency as recommended here:
// https://www.reddit.com/r/Hyperskill/comments/10kazu6/can_i_use_thirdparty_libraries_for_projects/
class CalcGrammar: Grammar<CalcExpression>() {
    private val num by regexToken("[-+]?\\d+")
    private val nme by regexToken("[a-zA-Z]+")
    // private val lparens by literalToken("(")
    // private val rparens by literalToken(")")
    // private val pow by literalToken("^")
    // private val mul by literalToken("*")
    // private val div by literalToken("/")
    private val pls by regexToken("\\++|(--)+ ")
    private val min by regexToken("-(--)* ")
    private val asn by literalToken("=")
    private val wsp by regexToken("\\s+", ignore = true)

    private val term: Parser<CalcExpression> by
        (num use { Num(text.toInt()) }) or
        (nme use { Nme(text) }) // or
        // (skip(minus) and parser(::term) map { -it }) // or
        // (skip(lparens) and parser(::rootParser) and skip(rparens))

    // private val powChain by
        // leftAssociative(term, pow) { a, _, b -> a.toDouble().pow(b.toDouble()).toInt() }

    // private val mulDivChain by
        // leftAssociative(powChain, mul or div use { type }) { a, op, b -> if (op == div) a / b else a * b }

    private val sumSubChain by
        leftAssociative(term /* mulDivChain */, pls or min use { type }) { a, op, b -> if (op == pls) Add(a, b) else Sub(a, b) }

    private val bndChain by
        (nme and skip(asn) and term).map { (n, t) -> Bnd(n.text, t) } or
        sumSubChain

    override val rootParser by bndChain
}

class ParseException(message: String): Exception(message)

fun preParse(input: String): String {
    if (input.matches(Regex("\\s*[a-zA-Z0-9]+\\s*"))) {
        if (!input.matches(Regex("\\s*[a-zA-Z]+\\s*")) && !input.matches(Regex("\\s*[-+]?\\d+\\s*"))) {
            throw ParseException("Invalid identifier")
        }
    }
    if (input.contains("=")) {
        val lhs = input.substringBefore("=")
        val rhs = input.substringAfter("=")
        if (!lhs.matches(Regex("\\s*[a-zA-Z]+\\s*"))) {
            throw ParseException("Invalid identifier")
        }
        if (!rhs.matches(Regex("\\s*[a-zA-Z]+\\s*")) && !rhs.matches(Regex("\\s*[-+]?\\d+\\s*"))) {
            throw ParseException("Invalid assignment")
        }
    }
    return input
}

fun repl(grmr: CalcGrammar = CalcGrammar(), bnds: Map<String, Int> = emptyMap()) {
    val input = readln()
    if ((input.startsWith("/"))) {
        when (input.drop(1)) {
            "help" -> println("The program calculates the sum of numbers")
            "exit" -> return println("Bye!")
            else -> println("Unknown command")
        }
        repl(grmr, bnds)
    } else {
        if (input == "") return repl(grmr, bnds)
        try {
            val expr = grmr.parseToEnd(preParse(input))
            val (i, newBnds) = eval(expr, bnds)
            if (i != null) println(i)
            repl(grmr, newBnds)
        } catch (e: Exception) {
            when (e) {
                is ParseException -> println(e.message)
                is EvalException -> println(e.message)
                else -> println("Invalid expression")
            }
            repl(grmr, bnds)
        }
    }
}

fun main() = repl()

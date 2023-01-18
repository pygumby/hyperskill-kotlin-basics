package calculator

operator fun Regex.contains(cs: CharSequence): Boolean = this.matches(cs)

sealed interface Tkn
data class NumTkn(val text: String): Tkn
data class PlusTkn(val text: String): Tkn
data class MinusTkn(val text: String): Tkn

fun tokenize(text: String): List<Tkn> = text
    .split(Regex("""\s+"""))
    .map { when (it) {
        in Regex("""-?\d+""") -> NumTkn(it)
        in Regex("""\+""") -> PlusTkn(it)
        in Regex("""-""") -> MinusTkn(it)
        else -> error("Cannot tokenize: $it")
    } }

sealed interface Expr
data class NumExpr(val n: Int): Expr
data class AddExpr(val op1: Expr, val op2: Expr): Expr
data class SubExpr(val op1: Expr, val op2: Expr): Expr

fun parse(
    tkns: List<Tkn>,
    operands: ArrayDeque<Tkn> = ArrayDeque<Tkn>(),
    operators: ArrayDeque<Tkn> = ArrayDeque<Tkn>()
): Expr = when (val currentTkn = tkns.first()) {
    is NumTkn ->
}

fun eval(expr: Expr): Int = when (expr) {
    is NumExpr -> expr.n
    is AddExpr -> eval(expr.op1) + eval(expr.op2)
    is SubExpr -> eval(expr.op1) - eval(expr.op2)
}

fun calc(input: String): Int = eval(parse(tokenize(input)))

fun main() {
    val input = "-2   + 3 - -17      + 4"
    val tokens = tokenize(input)
    val exprs = parse(tokens)
    val res = eval(exprs)

    println("Input:  $input")
    println("Tokens: $tokens")
    println("Exprs:  $exprs")
    println("Res:    $res")
}

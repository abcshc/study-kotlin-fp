package study.kotlin.fp.nobreak

fun fibonacciNumbers(n: Int): Int {
    if (n == 0) return 0
    if (n == 1) return 1
    return fibonacciNumbers(n - 1) + fibonacciNumbers(n - 2)
}

fun fibonacciNumbersUsingWhen(n: Int): Int = when (n) {
    0 -> 0
    1 -> 1
    else -> fibonacciNumbers(n - 1) + fibonacciNumbers(n - 2)
}

fun fibonacciNumbersUsingIterator(n: Int): Int {
    var first = 0
    var second = 1
    if (n == 0) return first
    if (n == 1) return second
    for (i in 1 until n) {
        val sum = first + second
        first = second
        second = sum
    }
    return second
}

val memo: MutableList<Int> = mutableListOf(0, 1)
fun fibonacciNumbersUsingMemoization(n: Int): Int = memo.getOrElse(n) {
    val result = fibonacciNumbersUsingMemoization(n - 1) + fibonacciNumbersUsingMemoization(n - 2)
    memo.add(n, result)
    return@getOrElse result
}

tailrec fun fibonacciNumbersUsingTailrec(n: Int, acc1: Int = 0, acc2: Int = 1): Int = when (n) {
    0 -> acc1
    1 -> acc2
    else -> fibonacciNumbersUsingTailrec(n - 1, acc2, acc1 + acc2)
}


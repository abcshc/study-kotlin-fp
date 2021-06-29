package study.kotlin.fp

import java.math.BigInteger

object TailRecursive {
    tailrec fun fibonacciNumbers(
        n: Int,
        acc1: BigInteger = BigInteger.ZERO,
        acc2: BigInteger = BigInteger.ONE
    ): BigInteger = when (n) {
        0 -> acc1
        1 -> acc2
        else -> fibonacciNumbers(n - 1, acc2, acc1 + acc2)
    }
    
    tailrec fun factorial(n: Int, acc: Int = 1): Int = when (n) {
        0 -> acc
        else -> factorial(n - 1, acc * n)
    }
    
    tailrec fun power(base: Int, exponent: Int, acc: Int = 1): Int = when (exponent) {
        0 -> acc
        else -> power(base, exponent - 1, base * acc)
    }
    
    tailrec fun List<Int>.maximum(value: Int = 0): Int = when (this.size) {
        0 -> error("empty list")
        1 -> this.first()
        else -> this.subList(1, this.size).maximum(kotlin.math.max(value, this[0]))
    }
    
    tailrec fun <E> List<E>.reverse(acc: List<E> = emptyList()): List<E> = when (this.size) {
        0 -> emptyList()
        1 -> acc + this
        else -> this@reverse.subList(0, this@reverse.size - 1).reverse(acc)
    }
}

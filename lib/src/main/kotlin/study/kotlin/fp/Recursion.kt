package study.kotlin.fp

import java.math.BigInteger

object Recursion {
    fun fibonacciNumbers(n: Int): BigInteger {
        return when (n) {
            0 -> BigInteger.ZERO
            1 -> BigInteger.ONE
            else -> fibonacciNumbers(n - 1) + fibonacciNumbers(n - 2)
        }
    }
    
    fun power(base: Int, exponent: Int): Int {
        return when (exponent) {
            0 -> 1
            else -> base * power(base, exponent - 1)
        }
    }
    
    fun factorial(n: Int): Int {
        return when (n) {
            0 -> 1
            else -> factorial(n - 1) * n
        }
    }
    
    fun List<Int>.max(): Int {
        return when (this.size) {
            0 -> throw EmptyListException()
            1 -> this.first()
            else -> kotlin.math.max(this[0], this.subList(1, this.size).max())
        }
    }
}

class EmptyListException: RuntimeException()

package study.kotlin.fp

import java.math.BigInteger

object Recursion {
    fun fibonacciNumbers(n: Int): BigInteger = when (n) {
        0 -> BigInteger.ZERO
        1 -> BigInteger.ONE
        else -> fibonacciNumbers(n - 1) + fibonacciNumbers(n - 2)
    }
    
    fun power(base: Int, exponent: Int): Int = when (exponent) {
        0 -> 1
        else -> base * power(base, exponent - 1)
    }
    
    fun factorial(n: Int): Int = when (n) {
        0 -> 1
        else -> factorial(n - 1) * n
    }
    
    fun List<Int>.maximum(): Int = when (this.size) {
        0 -> error("empty list")
        1 -> this.first()
        else -> kotlin.math.max(this[0], this.subList(1, this.size).maximum())
    }
    
    fun <E> List<E>.reverse(): List<E> = when (this.size) {
        0 -> throw error("empty list")
        1 -> this
        else -> mutableListOf<E>().apply {
            add(this@reverse.last())
            addAll(this@reverse.subList(0, this@reverse.size - 1).reverse())
        }
    }
    
    fun convertDecimalToBinaryString(decimal: Int): String = when (decimal) {
        0 -> "0"
        1 -> "1"
        else -> convertDecimalToBinaryString(decimal / 2) + (decimal % 2).toString()
    }
    
    fun replicate(count: Int, target: Int): List<Int> = when (count) {
        0 -> listOf()
        1 -> listOf(target)
        else -> mutableListOf<Int>().apply {
            add(target)
            addAll(replicate(count - 1, target))
        }
    }
    
    fun <E> take(count: Int, list: List<E>): List<E> = when (count) {
        0 -> listOf()
        1 -> listOf(list.first())
        else -> mutableListOf<E>().apply {
            add(list.first())
            addAll(take(count - 1, list.subList(1, list.size)))
        }
    }
}

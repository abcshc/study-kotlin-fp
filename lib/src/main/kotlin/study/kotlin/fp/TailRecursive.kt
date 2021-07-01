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
        1 -> kotlin.math.max(value, this.first())
        else -> this.subList(1, this.size).maximum(kotlin.math.max(value, this[0]))
    }
    
    tailrec fun <E> List<E>.reverse(acc: List<E> = emptyList()): List<E> = when (this.size) {
        0 -> acc
        1 -> acc + this
        else -> this@reverse.subList(0, this@reverse.size - 1).reverse(acc + this.last())
    }
    
    tailrec fun convertDecimalToBinaryString(decimal: Int, acc: String = ""): String = when (decimal) {
        0 -> "0$acc"
        1 -> "1$acc"
        else -> convertDecimalToBinaryString(decimal / 2, (decimal % 2).toString() + acc)
    }
    
    tailrec fun replicate(count: Int, target: Int, acc: List<Int> = emptyList()): List<Int> = when (count) {
        0 -> acc
        1 -> listOf(target) + acc
        else -> replicate(count - 1, target, listOf(target) + acc)
    }
    
    tailrec fun <E> take(count: Int, list: List<E>, acc: List<E> = emptyList()): List<E> = when (count) {
        0 -> acc
        1 -> acc + listOf(list.first())
        else -> take(count - 1, list.subList(1, list.size), acc + listOf(list.first()))
    }
    
    tailrec fun <E> zip(list1: List<E>, list2: List<E>, acc: List<Pair<E, E>> = emptyList()): List<Pair<E, E>> = when {
        list1.isEmpty() || list2.isEmpty() -> acc
        else -> zip(
            list1.subList(1, list1.size),
            list2.subList(1, list2.size),
            acc + Pair(list1.first(), list2.first())
        )
    }
    
    tailrec fun <E> List<E>.elem(value: E, result: Boolean = false): Boolean = when {
        result -> true
        this.isEmpty() -> false
        else -> this.subList(1, this.size).elem(value, this.first() == value)
    }
}

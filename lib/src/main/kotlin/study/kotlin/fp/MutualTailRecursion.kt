package study.kotlin.fp

import java.math.BigDecimal
import kotlin.math.sqrt

sealed class Bounce<A>
data class Done<A>(val result: A): Bounce<A>()
data class More<A>(val thunk: () -> Bounce<A>): Bounce<A>()

tailrec fun <A> trampoline(bounce: Bounce<A>): A = when (bounce) {
    is Done -> bounce.result
    is More -> trampoline(bounce.thunk())
}

object MutualTailRecursion {
    fun odd(n: Int): Bounce<Boolean> = when (n) {
        0 -> Done(false)
        else -> More { even(n - 1) }
    }
    
    fun even(n: Int): Bounce<Boolean> = when (n) {
        0 -> Done(true)
        else -> More { odd(n - 1) }
    }
    
    // 제곱근을 구하는 함수와 2로 나누는 함수를 쪼개기
    fun divideTwo(n: Double): Bounce<Double> = when {
        n < 1 -> Done(n)
        else -> More { squareRoot(n / 2) }
    }
    
    fun squareRoot(n: Double): Bounce<Double> = when {
        n < 1 -> Done(n)
        else -> More { divideTwo(sqrt(n)) }
    }
    
    fun factorial(n: BigDecimal, acc: BigDecimal = BigDecimal.ONE): Bounce<BigDecimal> = when (n) {
        BigDecimal.ZERO -> Done(acc)
        else -> More { factorial(n - BigDecimal.ONE, n * acc) }
    }
}

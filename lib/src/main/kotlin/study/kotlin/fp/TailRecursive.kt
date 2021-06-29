package study.kotlin.fp

object TailRecursive {
    tailrec fun factorial(n: Int, acc: Int = 1): Int = when (n) {
        0 -> acc
        else -> factorial(n - 1, acc * n)
    }
    
    tailrec fun power(base: Int, exponent: Int, acc: Int = 1): Int = when (exponent) {
        0 -> acc
        else -> power(base, exponent - 1, base * acc)
    }
}

package study.kotlin.fp

import kotlin.math.min

object Composition {
    // (F) -> R . (G) -> F
    infix fun <F, G, R> ((F) -> R).compose(g: (G) -> F): (G) -> R {
        return { gInput: G -> this(g(gInput)) }
    }
    
    tailrec fun <P1, P2, R> zipWith(list1: List<P1>, list2: List<P2>, func: (P1, P2) -> R, acc: List<R> = listOf()): List<R> {
        return when {
            list1.isEmpty() || list2.isEmpty() -> acc
            else -> zipWith(list1.drop(1), list2.drop(1), func, acc + func(list1.first(), list2.first()))
        }
    }
}

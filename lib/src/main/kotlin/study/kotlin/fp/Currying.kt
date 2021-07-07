package study.kotlin.fp

object Currying {
    fun <P1, P2, R> ((P1, P2) -> R).partial1(p1: P1): (P2) -> R {
        return { p2 -> this(p1, p2) }
    }
    
    fun <P1, P2, R> ((P1, P2) -> R).partial2(p2: P2): (P1) -> R {
        return { p1 -> this(p1, p2) }
    }
    
    fun <P1, P2, P3, R> ((P1, P2, P3) -> R).threePartial(p1: P1): (P2, P3) -> R {
        return { p2, p3 -> this(p1, p2, p3) }
    }
    
    fun <P1, P2, P3, R> ((P1, P2, P3) -> R).threePartialV2(p1: P1): (P2) -> (P3) -> R {
        return { p2 -> { p3 -> this(p1, p2, p3) } }
    }
    
    fun curryingMultiThree(a: Int) = { b: Int -> { c: Int -> a * b * c } }
    
    fun <P1, P2, P3, R> ((P1, P2, P3) -> R).curried(): (P1) -> (P2) -> (P3) -> R =
        { p1: P1 -> { p2: P2 -> { p3: P3 -> this(p1, p2, p3) } } }
    
    fun <P1, P2, P3, R> ((P1) -> (P2) -> (P3) -> R).uncurried(): (P1, P2, P3) -> R =
        { p1: P1, p2: P2, p3: P3 -> this(p1)(p2)(p3) }
    
    fun <P1, P2, R> ((P1, P2) -> R).curried(): (P1) -> (P2) -> R =
        { p1: P1 -> { p2: P2 -> this(p1, p2) } }
}

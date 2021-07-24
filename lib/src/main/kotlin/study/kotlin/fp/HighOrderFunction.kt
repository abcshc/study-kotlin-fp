package study.kotlin.fp

object HighOrderFunction {
    fun higherOrder(func: (Int, Int) -> Int, x: Int, y: Int): Int = func(x, y)
    
    val sum: (Int, Int) -> Int = { x, y -> x + y }
    val minus: (Int, Int) -> Int = { x, y -> x - y }
    val product: (Int, Int) -> Int = { x, y -> x * y }
    val twiceSum: (Int, Int) -> Int = { x, y -> (x + y) * 2 }
    
    
    tailrec fun <P> takeWhile(condition: (P) -> Boolean, list: List<P>, acc: List<P> = listOf()): List<P> {
        return when {
            list.isEmpty() || !condition(list.first()) -> acc
            else -> takeWhile(condition, list.drop(1), acc + list.first())
        }
    }
    
    tailrec fun <P> takeWhile(condition: (P) -> Boolean, sequence: Sequence<P>, acc: List<P> = listOf()): List<P> {
        return when {
            sequence.none() || !condition(sequence.first()) -> acc
            else -> takeWhile(condition, sequence.drop(1), acc + sequence.first())
        }
    }
}

class PartialFunction<P, R>(
    private val condition: (P) -> Boolean,
    private val f: (P) -> R
): (P) -> R {
    override fun invoke(p: P): R = when {
        condition(p) -> f(p)
        else -> throw IllegalArgumentException("$p isn't supported.")
    }
    
    fun isDefinedAt(p: P): Boolean = condition(p)
    
    fun invokeOrElse(p: P, default: R): R = when {
        condition(p) -> f(p)
        else -> default
    }
    
    fun orElse(that: PartialFunction<P, R>): PartialFunction<P, R> {
        return PartialFunction({ this.isDefinedAt(it) || that.isDefinedAt(it) },
            {
                when {
                    this.isDefinedAt(it) -> this(it)
                    that.isDefinedAt(it) -> that(it)
                    else -> throw IllegalArgumentException("$it isn't defined")
                }
            }
        )
    }
}

val condition = { it: Int -> it % 2 == 0 }
val body = { it: Int -> "$it is even" }
val isEven = PartialFunction(condition, body)
val isOdd = { i: Int -> "$i is odd" }.toPartialFunction{ !condition(it) }

fun <P, R> ((P) -> R).toPartialFunction(definedAt: (P) -> Boolean): PartialFunction<P, R> =
    PartialFunction(definedAt, this)

val isEvenUsingToPartialFunction = body.toPartialFunction(condition)

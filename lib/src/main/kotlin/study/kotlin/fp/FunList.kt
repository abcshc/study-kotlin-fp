package study.kotlin.fp

sealed class FunList<out T> {
    object Nil: FunList<Nothing>()
    data class Cons<out T>(val head: T, val tail: FunList<T>): FunList<T>()
}

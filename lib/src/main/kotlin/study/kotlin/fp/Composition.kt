package study.kotlin.fp

object Composition {
    // (F) -> R . (G) -> F
    infix fun <F, G, R> ((F) -> R).compose(g: (G) -> F): (G) -> R {
        return { gInput: G -> this(g(gInput)) }
    }
}

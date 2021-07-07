package study.kotlin.fp

import org.junit.Test
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class HighOrderFunctionTest {
    @Test
    fun `higherOrder calculator`() {
        assertEquals(6, HighOrderFunction.higherOrder(HighOrderFunction.sum, 1, 5))
        assertEquals(3, HighOrderFunction.higherOrder(HighOrderFunction.minus, 5, 2))
        assertEquals(8, HighOrderFunction.higherOrder(HighOrderFunction.product, 4, 2))
        assertEquals(12, HighOrderFunction.higherOrder(HighOrderFunction.twiceSum, 4, 2))
        assertEquals(44, HighOrderFunction.higherOrder({ x, y -> x * 10 + y * 2 }, 4, 2))
    }
    
    @Test
    fun `PartialFunction success`() {
        val oneTwoThree: (Int) -> String = PartialFunction({ it in 1..3 }, {
            when (it) {
                1 -> "one"
                2 -> "two"
                3 -> "three"
                else -> throw IllegalArgumentException()
            }
        })
        assertEquals("one", oneTwoThree(1))
        assertEquals("two", oneTwoThree(2))
        assertEquals("three", oneTwoThree(3))
        assertFailsWith<IllegalArgumentException> { oneTwoThree(4) }
    }
    
    @Test
    fun `isEven success`() {
        assertEquals(true, isEven.isDefinedAt(100))
        assertEquals("100 is even", isEven(100))
        assertEquals(false, isEven.isDefinedAt(99))
        assertFailsWith<IllegalArgumentException> { isEven(99) }
    }
    
    @Test
    fun `isEven using toPartialFunction success`() {
        assertEquals(true, isEvenUsingToPartialFunction.isDefinedAt(100))
        assertEquals("100 is even", isEvenUsingToPartialFunction(100))
        assertEquals(false, isEvenUsingToPartialFunction.isDefinedAt(99))
        assertFailsWith<IllegalArgumentException> { isEvenUsingToPartialFunction(99) }
    }
    
    @Test
    fun `isEven add invokeOrElse, orElse function success`() {
        assertEquals("Odd", isEven.invokeOrElse(99, "Odd"))
        assertEquals("99 is odd", isEven.orElse(isOdd)(99))
    }
}

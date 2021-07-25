package study.kotlin.fp

import org.junit.Test
import study.kotlin.fp.Currying.curried
import study.kotlin.fp.Currying.curryingMultiThree
import study.kotlin.fp.Currying.partial1
import study.kotlin.fp.Currying.partial2
import study.kotlin.fp.Currying.threePartial
import study.kotlin.fp.Currying.threePartialV2
import study.kotlin.fp.Currying.uncurried
import kotlin.test.assertEquals

internal class CurryingTest {
    @Test
    fun `partial applied function success`() {
        val func = { a: String, b: String -> "$a $b" }
        val partiallyAppliedFunc1 = func.partial1("Hello")
        assertEquals("Hello World", partiallyAppliedFunc1("World"))
        val partiallyAppliedFunc1Result = func.partial1("Hello")("World")
        assertEquals("Hello World", partiallyAppliedFunc1Result)
        val partiallyAppliedFunc2 = func.partial2("Hello")
        assertEquals("World Hello", partiallyAppliedFunc2("World"))
    }
    
    @Test
    fun `threePartial success`() {
        val func1 = { a: String, b: String, c: String -> "$a $b $c" }
        val result1 = func1.threePartial("A").partial1("B")("C")
        assertEquals("A B C", result1)
        val func2 = { a: String, b: String, c: String -> "$a $b $c" }
        val result2 = func2.threePartialV2("A")("B")("C")
        assertEquals("A B C", result2)
    }
    
    @Test
    fun `multiThree success`() {
        val partial1 = curryingMultiThree(1)
        val partial2 = partial1(2)
        val partial3 = partial2(3)
        assertEquals(6, partial3)
        assertEquals(6, curryingMultiThree(1)(2)(3))
    }
    
    @Test
    fun `curried, uncurried success`() {
        val func1 = { a: String, b: String, c: String -> "$a $b $c" }
        val curried = func1.curried()
        assertEquals("A B C", curried("A")("B")("C"))
        val uncurried = curried.uncurried()
        assertEquals("A B C", uncurried("A", "B", "C"))
    }
    
    @Test
    fun `min curried success`() {
        val min = { a: Int, b: Int -> if (a <= b) a else b }
        val curried = min.curried()
        assertEquals(1, curried(1)(5))
    }
    
    @Test
    fun `curring for callback`() {
        assertEquals("12345", Currying.callback("1")("2")("3")("4")("5"))
        
        val partialApplied = Currying.callback("prefix")(":")
        
        assertEquals("prefix:123", partialApplied("1")("2")("3"))
        assertEquals("prefix:abc", partialApplied("a")("b")("c"))
    }
}

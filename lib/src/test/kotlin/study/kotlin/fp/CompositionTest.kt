package study.kotlin.fp

import org.junit.Test
import study.kotlin.fp.Composition.compose
import study.kotlin.fp.Recursion.power
import kotlin.math.abs
import kotlin.test.assertEquals

internal class CompositionTest {
    private fun exampleForComposed(i: Int) = addThree(twice(i))
    private fun addThree(i: Int) = i + 3
    private fun twice(i: Int) = i * 2
    
    @Test
    fun `composed example`() {
        assertEquals(13, exampleForComposed(5))
    }
    
    @Test
    fun `using compose infix function`() {
        val addThree = { i: Int -> addThree(i) }
        val twice = { i: Int -> twice(i) }
        val composed = addThree compose twice
        
        assertEquals(13, composed(5))
    }
    
    @Test
    fun `using compose infix function 2`() {
        val absolute = { i: List<Int> -> i.map { abs(it) } }
        val negative = { i: List<Int> -> i.map { -it } }
        val minimum = { i: List<Int> -> i.minOrNull() }
        val composed = minimum compose negative compose absolute
        
        assertEquals(-14, composed(listOf(3, -1, 5, -2, -4, 8, 14)))
    }
    
    @Test
    fun `max power function`() {
        val max = { i: List<Int> -> i.maxOrNull() }
        val power = { i: Int? -> power(i ?: 0, 2) }
        val composed = power compose max
        
        assertEquals(4, composed(listOf(1, 2)))
    }
}



package study.kotlin.fp

import study.kotlin.fp.Recursion.maximum
import study.kotlin.fp.Recursion.reverse
import java.math.BigInteger
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class RecursionTest {
    @Test
    fun `fibonacciNumbers success`() {
        val result = listOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377)
        
        for (i in 0..14) {
            assertEquals(BigInteger.valueOf(result[i].toLong()), Recursion.fibonacciNumbers(i))
        }
    }
    
    @Test(timeout = 500)
    @Ignore("test that fails")
    fun `fibonacciNumbers big number`() {
        assertEquals(BigInteger("9969216677189303386214405760200"), Recursion.fibonacciNumbers(150))
    }
    
    @Test
    fun `power success`() {
        assertEquals(1024, Recursion.power(2, 10))
        assertEquals(32768, Recursion.power(2, 15))
        assertEquals(1000000000, Recursion.power(10, 9))
    }
    
    @Test
    fun `factorial success`() {
        assertEquals(1, Recursion.factorial(1))
        assertEquals(39916800, Recursion.factorial(11))
        assertEquals(479001600, Recursion.factorial(12))
    }
    
    @Test
    fun `list maximum success`() {
        assertEquals(7, listOf(1, 2, 5, 6, 7, 2, 3, 4, 5, 6).maximum())
        assertEquals(76, listOf(76, 23, 46, 76, 23, 1, 0).maximum())
        assertEquals(3, listOf(3).maximum())
        assertFailsWith<IllegalStateException> { listOf<Int>().maximum() }
    }
    
    @Test
    fun `list reverse success`() {
        assertEquals(listOf("C", "D", "A", "E", "A"), listOf("A", "E", "A", "D", "C").reverse())
        assertEquals(listOf(0, 9, 8, 7, 6, 5, 4, 3, 2, 1), listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0).reverse())
    }
    
    @Test
    fun `convertDecimalToBinaryString success`() {
        assertEquals("11", Recursion.convertDecimalToBinaryString(3))
        assertEquals("1001111001011111001", Recursion.convertDecimalToBinaryString(324345))
    }
    
    @Test
    fun `replicate success`() {
        assertEquals(listOf(5, 5, 5), Recursion.replicate(3, 5))
        assertEquals(listOf(88, 88, 88, 88, 88, 88), Recursion.replicate(6, 88))
    }
    
    @Test
    fun `take success`() {
        assertEquals(listOf("가", "나", "다"), Recursion.take(3, listOf("가", "나", "다", "라", "마", "바")))
        assertEquals(listOf("가"), Recursion.take(1, listOf("가", "나", "다", "라", "마", "바")))
        assertEquals(listOf(), Recursion.take(0, listOf("가", "나", "다", "라", "마", "바")))
        assertEquals(listOf(55, 24, 23, 65, 34, 65, 34, 12, 34), Recursion.take(9, listOf(55, 24, 23, 65, 34, 65, 34, 12, 34, 23)))
    }
}

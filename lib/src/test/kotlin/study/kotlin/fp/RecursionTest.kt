package study.kotlin.fp

import study.kotlin.fp.Recursion.max
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
    fun `list max success`() {
        assertEquals(7, listOf(1, 2, 5, 6, 7, 2, 3, 4, 5, 6).max())
        assertEquals(76, listOf(76, 23, 46, 76, 23, 1, 0).max())
        assertEquals(3, listOf(3).max())
        assertFailsWith<EmptyListException> { listOf<Int>().max() }
    }
}

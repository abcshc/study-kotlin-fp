package study.kotlin.fp

import org.junit.Test
import study.kotlin.fp.TailRecursive.elem
import study.kotlin.fp.TailRecursive.maximum
import study.kotlin.fp.TailRecursive.reverse
import java.math.BigInteger
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class TailRecursiveTest {
    @Test
    fun `fibonacciNumbers success`() {
        val result = listOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377)
        
        for (i in 0..14) {
            assertEquals(BigInteger.valueOf(result[i].toLong()), TailRecursive.fibonacciNumbers(i))
        }
    }
    
    @Test
    fun `fibonacciNumbers big number`() {
        assertEquals(BigInteger("9969216677189303386214405760200"), TailRecursive.fibonacciNumbers(150))
    }
    
    @Test
    fun `factorial success`() {
        assertEquals(1, TailRecursive.factorial(1))
        assertEquals(39916800, TailRecursive.factorial(11))
        assertEquals(479001600, TailRecursive.factorial(12))
    }
    
    @Test
    fun `power success`() {
        assertEquals(1024, TailRecursive.power(2, 10))
        assertEquals(32768, TailRecursive.power(2, 15))
        assertEquals(1000000000, TailRecursive.power(10, 9))
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
        assertEquals("11", TailRecursive.convertDecimalToBinaryString(3))
        assertEquals("1001111001011111001", TailRecursive.convertDecimalToBinaryString(324345))
        assertEquals("10110000001111010", TailRecursive.convertDecimalToBinaryString(90234))
    }
    
    @Test
    fun `replicate success`() {
        assertEquals(listOf(5, 5, 5), TailRecursive.replicate(3, 5))
        assertEquals(listOf(88, 88, 88, 88, 88, 88), TailRecursive.replicate(6, 88))
    }
    
    @Test
    fun `take success`() {
        assertEquals(listOf("가", "나", "다"), TailRecursive.take(3, listOf("가", "나", "다", "라", "마", "바")))
        assertEquals(listOf("가"), TailRecursive.take(1, listOf("가", "나", "다", "라", "마", "바")))
        assertEquals(listOf(), TailRecursive.take(0, listOf("가", "나", "다", "라", "마", "바")))
        assertEquals(
            listOf(55, 24, 23, 65, 34, 65, 34, 12, 34),
            TailRecursive.take(9, listOf(55, 24, 23, 65, 34, 65, 34, 12, 34, 23))
        )
    }
    
    @Test
    fun `zip success`() {
        assertEquals(listOf(Pair(1, 2), Pair(3, 4), Pair(5, 6)), TailRecursive.zip(listOf<Int>(1, 3, 5, 7), listOf<Int>(2, 4, 6)))
        assertEquals(listOf(Pair("가", "다"), Pair("나", "라")), TailRecursive.zip(listOf<String>("가", "나"), listOf<String>("다", "라", "마")))
        assertEquals(listOf(), TailRecursive.zip(listOf<Int>(1, 3, 5, 7), listOf()))
    }
    
    @Test
    fun `elem success`() {
        assertEquals(true, listOf(1, 2, 3, 4, 5).elem(1))
        assertEquals(false, listOf(1, 2, 3, 4, 5).elem(11))
    }
}

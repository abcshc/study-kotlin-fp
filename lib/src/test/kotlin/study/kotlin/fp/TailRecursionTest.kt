package study.kotlin.fp

import org.junit.Test
import study.kotlin.fp.TailRecursion.elem
import study.kotlin.fp.TailRecursion.maximum
import study.kotlin.fp.TailRecursion.powerset
import study.kotlin.fp.TailRecursion.reverse
import java.math.BigDecimal
import java.math.BigInteger
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull

internal class TailRecursionTest {
    @Test
    fun `fibonacciNumbers success`() {
        val result = listOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377)
        
        for (i in 0..14) {
            assertEquals(BigInteger.valueOf(result[i].toLong()), TailRecursion.fibonacciNumbers(i))
        }
    }
    
    @Test
    fun `fibonacciNumbers big number`() {
        assertEquals(BigInteger("9969216677189303386214405760200"), TailRecursion.fibonacciNumbers(150))
    }
    
    @Test
    fun `factorial success`() {
        assertEquals(1, TailRecursion.factorial(1))
        assertEquals(39916800, TailRecursion.factorial(11))
        assertEquals(479001600, TailRecursion.factorial(12))
    }
    
    @Test
    fun `factorial BigDecimal success`() {
        assertEquals(BigDecimal(1), TailRecursion.factorial(BigDecimal.ONE))
        assertEquals(BigDecimal(39916800), TailRecursion.factorial(BigDecimal(11)))
        assertEquals(BigDecimal(479001600), TailRecursion.factorial(BigDecimal(12)))
        assertNotNull(TailRecursion.factorial(BigDecimal(100000)))
    }
    
    @Test
    fun `power success`() {
        assertEquals(1024, TailRecursion.power(2, 10))
        assertEquals(32768, TailRecursion.power(2, 15))
        assertEquals(1000000000, TailRecursion.power(10, 9))
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
        assertEquals("11", TailRecursion.convertDecimalToBinaryString(3))
        assertEquals("1001111001011111001", TailRecursion.convertDecimalToBinaryString(324345))
        assertEquals("10110000001111010", TailRecursion.convertDecimalToBinaryString(90234))
    }
    
    @Test
    fun `replicate success`() {
        assertEquals(listOf(5, 5, 5), TailRecursion.replicate(3, 5))
        assertEquals(listOf(88, 88, 88, 88, 88, 88), TailRecursion.replicate(6, 88))
    }
    
    @Test
    fun `take success`() {
        assertEquals(listOf("가", "나", "다"), TailRecursion.take(3, listOf("가", "나", "다", "라", "마", "바")))
        assertEquals(listOf("가"), TailRecursion.take(1, listOf("가", "나", "다", "라", "마", "바")))
        assertEquals(listOf(), TailRecursion.take(0, listOf("가", "나", "다", "라", "마", "바")))
        assertEquals(
            listOf(55, 24, 23, 65, 34, 65, 34, 12, 34),
            TailRecursion.take(9, listOf(55, 24, 23, 65, 34, 65, 34, 12, 34, 23))
        )
    }
    
    @Test
    fun `zip success`() {
        assertEquals(
            listOf(Pair(1, 2), Pair(3, 4), Pair(5, 6)),
            TailRecursion.zip(listOf<Int>(1, 3, 5, 7), listOf<Int>(2, 4, 6))
        )
        assertEquals(
            listOf(Pair("가", "다"), Pair("나", "라")),
            TailRecursion.zip(listOf<String>("가", "나"), listOf<String>("다", "라", "마"))
        )
        assertEquals(listOf(), TailRecursion.zip(listOf<Int>(1, 3, 5, 7), listOf()))
    }
    
    @Test
    fun `elem success`() {
        assertEquals(true, listOf(1, 2, 3, 4, 5).elem(1))
        assertEquals(false, listOf(1, 2, 3, 4, 5).elem(11))
    }
    
    @Test
    fun `powerset success`() {
        assertEquals(
            setOf(
                setOf(), setOf(1), setOf(1, 2), setOf(1, 3),
                setOf(2), setOf(2, 3), setOf(3), setOf(1, 2, 3)
            ), setOf(1, 2, 3).powerset()
        )
        
        assertEquals(
            setOf(
                setOf(),
                setOf("가"), setOf("가", "나"), setOf("가", "다"), setOf("가", "A"),
                setOf("나"), setOf("나", "다"), setOf("나", "A"), setOf("가", "나", "다"), setOf("가", "나", "A"),
                setOf("다"), setOf("다", "A"), setOf("가", "다", "A"), setOf("나", "다", "A"), setOf("가", "나", "다", "A"),
                setOf("A")
            ), setOf("가", "나", "다", "A").powerset()
        )
    }
}

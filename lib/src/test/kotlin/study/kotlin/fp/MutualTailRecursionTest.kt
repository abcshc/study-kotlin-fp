package study.kotlin.fp

import org.junit.Test
import java.math.BigDecimal
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

internal class MutualTailRecursionTest {
    @Test
    fun `trampoline odd, even`() {
        assertEquals(false, trampoline(MutualTailRecursion.even(999999999)))
        assertEquals(true, trampoline(MutualTailRecursion.odd(999999999)))
    }
    
    @Test
    fun `trampoline divideTwo, squareRoot`() {
        assertEquals(0.7071067811865476, trampoline(MutualTailRecursion.divideTwo(4.0)))
        assertEquals(0.5, trampoline(MutualTailRecursion.squareRoot(4.0)))
        assertEquals(0.528685631720282, trampoline(MutualTailRecursion.squareRoot(5.0)))
    }
    
    @Test
    fun `trampoline factorial`() {
        assertEquals(BigDecimal(1), trampoline(MutualTailRecursion.factorial(BigDecimal.ONE)))
        assertEquals(BigDecimal(39916800), trampoline(MutualTailRecursion.factorial(BigDecimal(11))))
        assertEquals(BigDecimal(479001600), trampoline(MutualTailRecursion.factorial(BigDecimal(12))))
        assertNotNull(trampoline(MutualTailRecursion.factorial(BigDecimal(100000))))
    }
}

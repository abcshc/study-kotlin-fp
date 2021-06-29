package study.kotlin.fp

import org.junit.Test
import kotlin.test.assertEquals

internal class TailRecursiveTest {
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
}

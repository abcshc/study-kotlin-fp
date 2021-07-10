package study.kotlin.fp.nobreak

import org.junit.Test
import kotlin.test.assertEquals

internal class TailRecursionKtTest {
    @Test
    fun `fibonacciNumbers success`() {
        val result = listOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377)
        
        for (i in 0..14) {
            assertEquals(result[i], fibonacciNumbers(i))
        }
    }
    
    @Test
    fun `fibonacciNumbersUsingWhen success`() {
        val result = listOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377)
        
        for (i in 0..14) {
            assertEquals(result[i], fibonacciNumbersUsingWhen(i))
        }
    }
    
    @Test
    fun `fibonacciNumbersUsingIterator success`() {
        val result = listOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377)
        
        for (i in 0..14) {
            assertEquals(result[i], fibonacciNumbersUsingIterator(i))
        }
    }
    
    @Test
    fun `fibonacciNumbersUsingMemoization success`() {
        val result = listOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377)
        
        for (i in 0..14) {
            assertEquals(result[i], fibonacciNumbersUsingMemoization(i))
        }
    }
    
    @Test
    fun `fibonacciNumbersUsingTailrec success`() {
        val result = listOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377)
        
        for (i in 0..14) {
            assertEquals(result[i], fibonacciNumbersUsingTailrec(i))
        }
    }
}

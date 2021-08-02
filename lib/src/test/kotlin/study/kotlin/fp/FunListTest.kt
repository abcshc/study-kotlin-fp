package study.kotlin.fp

import org.junit.Test
import study.kotlin.fp.FunList.Cons
import study.kotlin.fp.FunList.Nil
import kotlin.test.assertEquals

internal class FunListTest {
    @Test
    fun `create FunList`() {
        val list = Cons(1, Cons(2, Nil))
        assertEquals(1, list.head)
        assertEquals(2, (list.tail as Cons).head)
        assertEquals(Nil, (list.tail as Cons).tail as Nil)
    }
    
    @Test
    fun `create Double FunList`() {
        val list: FunList<Double> = Cons(1.0, Cons(2.0, Cons(3.0, Cons(4.0, Cons(5.0, Nil)))))
        assertEquals(1.0, (list as Cons).head)
    }
    
    @Test
    fun `addHead success`() {
        val list = Cons(1, Nil).addHead(3) as Cons<Int>
        
        assertEquals(3, list.head)
        assertEquals(1, (list.tail as Cons).head)
    }
    
    @Test
    fun `appendTail success`() {
        val list = Cons(1, Nil).appendTail(3) as Cons<Int>
        
        assertEquals(1, list.head)
        assertEquals(3, (list.tail as Cons).head)
    }
    
    @Test
    fun `reverse success`() {
        val list = Cons(1, Cons(2, Nil)).reverse() as Cons<Int>
        
        assertEquals(2, list.head)
        assertEquals(1, (list.tail as Cons).head)
    }
}

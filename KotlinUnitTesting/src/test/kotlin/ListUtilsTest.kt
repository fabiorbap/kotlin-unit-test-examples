
import com.fabio.kotlin.unittesting.ListUtils
import org.junit.Assert.*
import org.junit.Test

class ListUtilsTest {

    @Test
    fun secondLargest_emptyList_nullReturned() {
        val result = ListUtils.secondLargest(listOf())
        assertEquals(null, result)
    }

    @Test
    fun secondLargest_lessThanTwoElements_nullReturned() {
        val result = ListUtils.secondLargest(listOf(0))
        assertEquals(null, result)
    }

    @Test
    fun secondLargest_multipleElements_correctReturned() {
        val list = listOf(1, 2, 0, 3)
        val expectedResult = 2
        val result = ListUtils.secondLargest(list)
        assertEquals(expectedResult, result)
    }

    @Test
    fun secondLargest_duplicatedLargestElement_correctReturned() {
        val list = listOf(1, 2, 4, 3, 5, 5)
        val expectedResult = 4
        val result = ListUtils.secondLargest(list)
        assertEquals(expectedResult, result)
    }

    @Test
    fun secondLargest_allElementsDuplicated_nullReturned() {
        val list = listOf(1, 1, 1, 1, 1)
        val result = ListUtils.secondLargest(list)
        assertEquals(null, result)
    }

    @Test
    fun isSorted_emptyList_trueReturned() {
        val list = emptyList<Int>()
        val result = ListUtils.isSorted(list)
        assertTrue(result)
    }

    @Test
    fun isSorted_singleElement_trueReturned() {
        val list = listOf(0)
        val result = ListUtils.isSorted(list)
        assertTrue(result)
    }

    @Test
    fun isSorted_sortedElements_trueReturned() {
        val list = listOf(0, 1, 2, 3)
        val result = ListUtils.isSorted(list)
        assertTrue(result)
    }

    @Test
    fun isSorted_unsortedElements_falseReturned() {
        val list = listOf(1, 3, 2)
        val result = ListUtils.isSorted(list)
        assertFalse(result)
    }

}
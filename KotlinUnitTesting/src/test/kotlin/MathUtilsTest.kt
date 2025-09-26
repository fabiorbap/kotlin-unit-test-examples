
import com.fabio.kotlin.unittesting.MathUtils
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MathUtilsTest {

    @Test
    fun factorial_passZero_oneReturned() {
        val expectedResult = 1
        val result = MathUtils.factorial(0)
        assertEquals(expectedResult, result)
    }

    @Test
    fun factorial_passOne_oneReturned() {
        val expectedResult = 1
        val result = MathUtils.factorial(1)
        assertEquals(expectedResult, result)
    }

    @Test
    fun factorial_passRandom_correctReturned() {
        val expectedResult = 120
        val result = MathUtils.factorial(5)
        assertEquals(expectedResult, result)
    }

    @Test
    fun factorial_passNegative_errorReturned() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            MathUtils.factorial(-1)
        }
        assertEquals("Factorial is not defined for negative numbers",
            exception.message)
    }

    @Test
    fun factorial_deepRecursion_errorReturned() {
        assertThrows(StackOverflowError::class.java) {
            MathUtils.factorial(1000000000)
        }
    }

    @Test
    fun isPrime_passZero_falseReturned() {
        val isPrime = MathUtils.isPrime(0)
        assertFalse(isPrime)
    }

    @Test
    fun isPrime_passOne_falseReturned() {
        val isPrime = MathUtils.isPrime(1)
        assertFalse(isPrime)
    }

    @Test
    fun isPrime_passTwo_trueReturned() {
        val isPrime = MathUtils.isPrime(2)
        assertTrue(isPrime)
    }

    @Test
    fun isPrime_passFive_trueReturned() {
        val isPrime = MathUtils.isPrime(5)
        assertTrue(isPrime)
    }

    @Test
    fun isPrime_passPair_falseReturned() {
        val isPrime = MathUtils.isPrime(4)
        assertFalse(isPrime)
    }

    @Test
    fun isPrime_passNine_falseReturned() {
        val isPrime = MathUtils.isPrime(9)
        assertFalse(isPrime)
    }

    @Test
    fun isPrime_passEleven_trueReturned() {
        val isPrime = MathUtils.isPrime(11)
        assertTrue(isPrime)
    }

    @Test
    fun isPrimePassSixtyOne_trueReturned() {
        val isPrime = MathUtils.isPrime(61)
        assertTrue(isPrime)
    }




}
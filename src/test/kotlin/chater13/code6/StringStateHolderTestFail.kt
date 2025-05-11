package chater13.code6

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import section13.code6.StringStateHolder

class StringStateHolderTestFail {
    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `updateStringWithDelay(ABC)가 호출되면 문자열이 ABC로 변경된다`() = runTest {
        // Given
        val stringStateHolder = StringStateHolder()

        // When
        stringStateHolder.updateStringWithDelay("ABC")

        // Then
        advanceUntilIdle()
        assertEquals("ABC", stringStateHolder.stringState)
    }
}
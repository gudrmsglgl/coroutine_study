package chater13.code6

import kotlinx.coroutines.test.StandardTestDispatcher
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import section13.code6.StringStateHolder2

class StringStateHolderTestSuccess {
    @Test
    fun `updateStringWidthDelay(ABC)가 호출되면 문자열이 ABC로 변경된다`() {
        // Given
        val testDispatcher = StandardTestDispatcher()
        val stringStateHolder2 = StringStateHolder2(testDispatcher)

        // When
        stringStateHolder2.updateStringWithDelay("ABC")

        // Then
        testDispatcher.scheduler.advanceUntilIdle()
        Assertions.assertEquals("ABC", stringStateHolder2.stringState)
    }
}
package chater13.code3

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import section13.code3.RepeatAddUseCase

class RepeatAddWithDelayUseCaseTest {
    @Test
    fun `runBlocking_100번 더하면 100이 반환된다`() = runBlocking {
        // Given
        val repeatAddUseCase = RepeatAddUseCase()

        // When
        val result = repeatAddUseCase.add(repeatTime = 100)

        // Then
        assertEquals(100, result)
    }
}
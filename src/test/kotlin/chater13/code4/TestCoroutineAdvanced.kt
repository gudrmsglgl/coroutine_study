package chater13.code4

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TestCoroutineAdvanced {

    @Test
    fun `advanceUntilIdle의 동작 살펴보기`() {
        // Given
        val testDispatcher = StandardTestDispatcher()
        val coroutineScope = CoroutineScope(context = testDispatcher)

        var result = 0

        // When
        coroutineScope.launch {
            delay(10_000L)
            result = 1
            delay(10_000L)
            result = 2
        }

        testDispatcher.scheduler.advanceUntilIdle()

        // Then
        Assertions.assertEquals(2, result)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `TestScope 사용하기`() {
        // Given
        val testScope = TestScope()

        var result = 0

        // When
        testScope.launch {
            delay(10_000L)
            result = 1
            delay(10_000L)
            result = 2
        }
        testScope.advanceUntilIdle()

        // Then
        Assertions.assertEquals(2, result)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `runTest 사용하기`() = runTest {
        // Given
        var result = 0

        // When
        delay(10_000L)
        result = 1
        delay(10_000L)
        result = 2

        // Then
        Assertions.assertEquals(2, result)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `runTest 내부에서 advanceUntilIdle 사용하기`() = runTest {
        var result = 0
        launch {
            delay(10_000L)
            result = 1
        }

        println("가상 시간: ${this.currentTime}ms, result = ${result}")
        advanceUntilIdle()
        println("가상 시간: ${this.currentTime}ms, result = ${result}")
    }
}
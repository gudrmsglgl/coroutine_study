package chater13.code4

import kotlinx.coroutines.*
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineScheduler
import kotlinx.coroutines.test.TestDispatcher
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TestCoroutineSchedulerTest {

    private lateinit var testCoroutineScheduler: TestCoroutineScheduler

    @BeforeEach
    fun setUp() {
        testCoroutineScheduler = TestCoroutineScheduler()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @AfterEach
    fun reset() {
        testCoroutineScheduler.advanceTimeBy(0L)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `가상 시간 조절 테스트`() {
        testCoroutineScheduler.advanceTimeBy(5000L)
        assertEquals(5000L, testCoroutineScheduler.currentTime)

        testCoroutineScheduler.advanceTimeBy(6000L)
        assertEquals(11000L, testCoroutineScheduler.currentTime)

        testCoroutineScheduler.advanceTimeBy(10000L)
        assertEquals(21000L, testCoroutineScheduler.currentTime)

    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `가상 시간 위에서 테스트 진행`() {
        // Given
        val testDispatcher = StandardTestDispatcher(testCoroutineScheduler)
        val coroutineScope = CoroutineScope(context = testDispatcher)

        var result = 0

        // When
        coroutineScope.launch {
            delay(10000L)
            result = 1
            delay(10000L)
            result = 2
        }

        // Then
        testCoroutineScheduler.advanceTimeBy(5000L)
        assertEquals(0, result)

        testCoroutineScheduler.advanceTimeBy(6000L)
        assertEquals(1, result)

        testCoroutineScheduler.advanceTimeBy(10000L)
        assertEquals(2, result)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `advanceUntilIdle의 동작 살펴보기`() {
        // Given
        val testDispatcher = StandardTestDispatcher(testCoroutineScheduler)
        val coroutineScope = CoroutineScope(context = testDispatcher)

        var result = 0

        // When
        coroutineScope.launch {
            delay(10_000L)
            result = 1
            delay(10_000L)
            result = 2
        }

        testCoroutineScheduler.advanceUntilIdle()

        // Then
        assertEquals(2, result)
    }
}
package chater13.code7

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class RunTestScopeWhileSuccess {
    @Test
    fun `backgroundScope를 사용하는 테스트`() = runTest {
        var result = 0

        backgroundScope.launch {
            while (true) {
                delay(1000L)
                result += 1
            }
        }

        advanceTimeBy(1500L)
        Assertions.assertEquals(1, result)
        advanceTimeBy(1000L)
        Assertions.assertEquals(2, result)
    }
}
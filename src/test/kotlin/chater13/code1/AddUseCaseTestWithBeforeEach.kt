package chater13.code1

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import section13.code1.AddUseCase

class AddUseCaseTestWithBeforeEach {
    private lateinit var addUseCase: AddUseCase

    @BeforeEach
    fun setUp() {
        addUseCase = AddUseCase()
    }

    @Test
    fun `1,2,3을 더하면 6이다`() {
        val result = addUseCase.add(1,2,3)
        Assertions.assertEquals(6, result)
    }

    @Test
    fun `-1더하기 1은 0이다`() {
        val result = addUseCase.add(-1,1)
        Assertions.assertEquals(0, result)
    }

}
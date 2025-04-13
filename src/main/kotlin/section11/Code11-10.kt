package section11

import kotlinx.coroutines.*

fun main(): Unit = runBlocking {
    val dispatcher = newFixedThreadPoolContext(2, "CustomThread")
    launch(dispatcher) {
        repeat(5) {
            println("[${Thread.currentThread().name}] 코루틴 실행 일시 중단")
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행 재개")
        }
    }
}
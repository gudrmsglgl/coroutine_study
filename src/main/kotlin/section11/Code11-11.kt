package section11

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val dispatcher = newFixedThreadPoolContext(2, "CustomThread")
    launch(dispatcher) {
        repeat(5) {
            println("[${Thread.currentThread().name}] 스레드 점유 100 대기")
            Thread.sleep(100L)
            println("[${Thread.currentThread().name}] 점유한 스레드로 마저 실행")
        }
    }
}
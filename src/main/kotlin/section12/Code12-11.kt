package section12

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    launch(Dispatchers.Unconfined) {
        println("[Dispatcher.Unconfined] 시작 스레드: ${Thread.currentThread().name}")
        delay(100L)
        println("[Dispatcher.Unconfined] 재개 스레드: ${Thread.currentThread().name}")
    }
}
package section12

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking(Dispatchers.IO) {
    println("runBlocking 코루틴 실행 스레드: ${Thread.currentThread().name}")
    launch(Dispatchers.Unconfined) {
        println("launch 코루틴 실행 스레드:${Thread.currentThread().name}")
    }
}
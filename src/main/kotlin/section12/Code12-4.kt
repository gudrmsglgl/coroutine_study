package section12

import kotlinx.coroutines.*

val countChangeDispatcher = newSingleThreadContext("전용 스레드")
var count4 = 0

fun main(): Unit = runBlocking {
    withContext(Dispatchers.Default) {
        repeat(10_000) {
            launch(countChangeDispatcher) {
                count4 += 1
            }
        }
    }
    println("count = $count4")
}
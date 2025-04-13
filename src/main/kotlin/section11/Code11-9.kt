package section11

import kotlinx.coroutines.*

fun main(): Unit = runBlocking {
    val job = launch(Dispatchers.Default) {
        while (this.isActive) {
            println("작업중")
        }
    }
    delay(100L)
    job.cancel()
}
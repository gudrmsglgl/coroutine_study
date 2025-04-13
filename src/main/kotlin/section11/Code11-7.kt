package section11

import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val job = launch {
        while (this.isActive) {
            println("작업중")
        }
    }
    delay(100L)
    job.cancel()
}
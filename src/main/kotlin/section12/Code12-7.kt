package section12

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val job = launch(start = CoroutineStart.ATOMIC) {
        println("작업1")
    }

    job.cancel()
    println("작업2")
}
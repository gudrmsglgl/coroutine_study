package section3.code2

import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val multithreadDispatcher = newFixedThreadPoolContext(2, "MultiThread")
    launch(multithreadDispatcher) {
        println("[${Thread.currentThread().name}]")
    }

    launch(multithreadDispatcher) {
        println("[${Thread.currentThread().name}]")
    }
}
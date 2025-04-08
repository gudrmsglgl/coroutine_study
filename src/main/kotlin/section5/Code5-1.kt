package section5

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main(): Unit = runBlocking {
    val result = withContext(Dispatchers.IO) {
        delay(1000L)
        println("[${Thread.currentThread().name}]")
        "결과 값"
    }

    println("[${Thread.currentThread().name}] result:$result")
}
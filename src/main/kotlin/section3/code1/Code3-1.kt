package section3.code1

import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val singleThreadDispatcher = newSingleThreadContext("SingleThread")
    launch(singleThreadDispatcher) {
        println("[${Thread.currentThread().name}] 실행")
    }

}
package section9

import kotlinx.coroutines.*

fun main(): Unit = runBlocking {
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("[핸들러] ${throwable}")
    }
    val exceptionHandler2 = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("[핸들러2] ${throwable}")
    }
    CoroutineScope(exceptionHandler)
        .launch(CoroutineName("Coroutine1") + exceptionHandler2) {
            launch(CoroutineName("Coroutine2")) {
                throw Exception("Coroutine2에 예외가 발생")
            }
        }
    delay(1000L)
}
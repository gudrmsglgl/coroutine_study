package section9

import kotlinx.coroutines.*

fun main(): Unit = runBlocking {
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("[예외 발생] ${throwable}")
    }
    CoroutineScope(Dispatchers.IO).launch(CoroutineName("Coroutine1")) {
        launch(CoroutineName("Coroutine2") + exceptionHandler) {
            throw Exception("Coroutine2에 예외가 발생")
        }
    }
    delay(1000L)
}
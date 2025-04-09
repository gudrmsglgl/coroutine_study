package section9

import kotlinx.coroutines.*
import java.lang.Exception

fun main(): Unit = runBlocking {
    supervisorScope {
        async(CoroutineName("Coroutine1")) {
            throw Exception("Coroutine1 예외가 발생했습니다.")
        }
        launch(CoroutineName("Coroutine2")) {
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
    }
}
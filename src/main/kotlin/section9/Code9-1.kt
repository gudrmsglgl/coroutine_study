package section9

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.Exception

fun main(): Unit = runBlocking {
    launch(CoroutineName("Coroutine1")) {
        try {
            throw Exception("Coroutine1 예외가 발생했습니다.")
        } catch (e: Exception) {
            println(e.message)
        }
    }
    launch(CoroutineName("Coroutine2")) {
        delay(100L)
        println("Coroutine2 실행 완료")
    }
}
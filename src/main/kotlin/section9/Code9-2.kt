package section9

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.Exception

fun main(): Unit = runBlocking {
    // 💩잘못된 예외 처리 예제
    try {
        launch(CoroutineName("Coroutine1")) {
            throw Exception("Coroutine1 예외가 발생했습니다.")
        }
    } catch (e: Exception) {
        println(e.message)
    }

    launch(CoroutineName("Coroutine2")) {
        delay(100L)
        println("Coroutine2 실행 완료")
    }
}
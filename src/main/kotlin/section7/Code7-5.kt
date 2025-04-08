package section7

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val newJob = Job()
    launch(CoroutineName("Coroutine1") + newJob) {
        launch(CoroutineName("Coroutine3")) {
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
        launch(CoroutineName("Coroutine4")) {
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
    }

    launch(CoroutineName("Coroutine2") + newJob) {
        launch(CoroutineName("Coroutine5") + Job()) {
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
    }
    delay(50L) // 모든 코루틴이 생성될 때까지 대기
    newJob.cancel()
    delay(1000L)
}
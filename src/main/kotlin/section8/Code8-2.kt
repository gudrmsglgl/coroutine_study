package section8

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val parentJob = launch(CoroutineName("Parent Coroutine")) {
        launch(CoroutineName("Coroutine1") + Job()) {
            launch(CoroutineName("Coroutine3")) {
                delay(100L)
                println("[${Thread.currentThread().name}] 코루틴 실행")
            }
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }

        launch(CoroutineName("Coroutine2")) {
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
    }
    delay(20L)
    parentJob.cancel()
    delay(1000L)
}
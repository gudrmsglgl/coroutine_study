package section7

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val parentJob = coroutineContext[Job]
    val newJob = Job(parent = parentJob)
    launch(CoroutineName("Coroutine2") + newJob) {
        delay(1000L)
        println("[${Thread.currentThread().name}] 코루틴 실행")
    }
    newJob.complete()
}
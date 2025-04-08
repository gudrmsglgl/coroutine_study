package section4.code4

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val longJob = launch(Dispatchers.Default) {
        delay(1000L)
        println("longJob 코루틴의 동작")
    }
    longJob.cancelAndJoin()
    executeAfterJobCancelled()
}

private fun executeAfterJobCancelled() {
    println("longJob 코루틴 취소 후 실행돼야 하는 동작")
}
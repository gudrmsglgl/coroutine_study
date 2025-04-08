package section7

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val parentJob = launch {
        launch {
            delay(1000L)
            println("${getElapsedTime(startTime)} 자식 코루틴 실행 완료")
        }
        println("${getElapsedTime(startTime)} 부모 코루틴이 실행하는 마지막 코드")
    }

    parentJob.invokeOnCompletion {
        println("${getElapsedTime(startTime)} 부모 코루틴 실행 완료")
    }
    delay(500L)
    println(parentJob)
}

private fun getElapsedTime(startTime: Long): String = "[지난 시간: ${System.currentTimeMillis() - startTime}ms]"
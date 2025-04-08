package section4.code4

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val longJob = launch(Dispatchers.Default) {
        repeat(10) { repeatTime ->
            delay(1000L)
            println("${getElapsedTime(startTime)} 반복횟수 ${repeatTime}")
        }
    }
    delay(2500L)
    longJob.cancel()
}

private fun getElapsedTime(startTime: Long): String {
    return "[지난 시간: ${System.currentTimeMillis() - startTime}밀리초]"
}
package section11

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main(): Unit  = runBlocking {
    val startTime = System.currentTimeMillis()
    repeat(10) { repeatTime ->
        launch {
            delay(1000L)
            println("${getElapsedTime(startTime)} 코루틴[$repeatTime] 실행완료")
        }
    }
}

private fun getElapsedTime(param: Long): String {
    return "[지난 시간: ${System.currentTimeMillis() - param}밀리초]"
}
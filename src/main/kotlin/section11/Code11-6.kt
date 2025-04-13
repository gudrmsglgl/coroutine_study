package section11

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit  = runBlocking {
    val childJob = launch {
        println("1. launch 코루틴 작업 시작")
        delay(1000L)
        println("2. launch 코루틴 작업 완료")
    }
    println("3. runBlocking 코루틴이 곧 일시 중단 되고 메인 스레드가 양보")
    childJob.join()
    println("4. runBlocking 메인 스레드에 보내져 작업이 다시 재개됨")
}

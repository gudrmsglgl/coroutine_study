package section11

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main(): Unit  = runBlocking {
    launch {
        while(true) {
            println("자식 코루틴에서 작업 실행 중")
            yield()
        }
    }

    while (true) {
        println("runBlocking 코루틴(부모) 작업 실행 중")
        yield()
    }
}
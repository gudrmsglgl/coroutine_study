package section12

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.concurrent.atomic.AtomicInteger

var count5 = AtomicInteger(0)

fun main(): Unit = runBlocking {
    withContext(Dispatchers.Default) {
        repeat(10_000) {
            launch {
                // get set 함수를 따로 실행하면 결과값이 달라짐
                // val currentCount = count5.get()
                // count5.set(currentCount +1)
                count5.getAndUpdate { it + 1 }
            }
        }
    }
    println("count = $count5")
}
package section12

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext

val mutex = Mutex()
var count3 = 0

fun main(): Unit = runBlocking {
    withContext(Dispatchers.Default) {
        repeat(10_000) {
            launch {
                /*mutex.lock()
                count3 += 1
                mutex.unlock()*/
                mutex.withLock {
                    count3 += 1
                }
            }
        }
    }
    println("count = $count3")
}
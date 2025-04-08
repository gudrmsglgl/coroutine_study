package section6

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    //Test.Key.createTest()
    Test.createTest()
    val coroutineContext = newSingleThreadContext("MyThread") + CoroutineName("MyCoroutine")
    launch(coroutineContext) {
        println("[${Thread.currentThread().name}] 실행")
    }
}

class Test {
    companion object Key {
        fun createTest() = Test()
    }
}
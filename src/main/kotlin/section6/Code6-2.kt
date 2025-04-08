package section6

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val coroutineName = CoroutineName("MyCoroutine")
    val dispatcher = Dispatchers.IO
    val coroutineContext = coroutineName + dispatcher

    println(coroutineContext[coroutineName.key])
    println(coroutineContext[dispatcher.key])
}
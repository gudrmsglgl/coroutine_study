package section9

import kotlinx.coroutines.*
import java.lang.Exception

fun main(): Unit = runBlocking {
    supervisorScope {
        val deferred = async(CoroutineName("Coroutine1")) {
            throw Exception("Coroutine1 예외가 발생했습니다.")
        }
        try {
            deferred.await()
        } catch (e: Exception) {
            println("[노출된 예외] ${e.message}")
        }
    }

}
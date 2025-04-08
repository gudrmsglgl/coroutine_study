package section7

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalCoroutinesApi::class)
fun main(): Unit = runBlocking {
    val parentJob = coroutineContext[Job]

    launch {
        val childJob = coroutineContext[Job]
        println("childJob에 부모는 parentJob 이다 : ${parentJob === childJob?.parent}")
        println("parentJob 의 자식들 중에 childJob을 가지고 있다 : ${parentJob?.children?.contains(childJob)}")
    }
}
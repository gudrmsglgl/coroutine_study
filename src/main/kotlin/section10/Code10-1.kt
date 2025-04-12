package section10

import kotlinx.coroutines.*

fun main(): Unit = runBlocking {
    val startTime = System.currentTimeMillis()
    val results = searchByKeyword("keyword")
    println("[결과] ${results.toList()}")
    println(getElapsedTime(startTime))
}

private fun getElapsedTime(param: Long): String {
    return "[지난 시간: ${System.currentTimeMillis() - param}밀리초]"
}

suspend fun searchByKeyword(keyword: String): Array<String> = coroutineScope {
    val dbResultsDeferred = async(CoroutineName("DB 코루틴")) {
        throw Exception("DB 읽기 오류 발생")
        searchFromDB(keyword)
    }

    val serverResultsDeferred = async(CoroutineName("서버 코루틴")) {
        searchFromServer(keyword)
    }

    return@coroutineScope arrayOf(*dbResultsDeferred.await(), *serverResultsDeferred.await())
}

private suspend fun searchFromDB(keyword: String): Array<String> {
    delay(1000L)
    return arrayOf("[DB]${keyword}1", "[DB]${keyword}2")
}

private suspend fun searchFromServer(keyword: String): Array<String> {
    delay(1000L)
    return arrayOf("[Server]${keyword}1", "[Server]${keyword}2")
}
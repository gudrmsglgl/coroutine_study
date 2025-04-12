package section10

import kotlinx.coroutines.*

fun main(): Unit = runBlocking {
    val startTime = System.currentTimeMillis()
    val results = searchByKeywordV2("keyword")
    println("[결과] ${results.toList()}")
    println(getElapsedTime(startTime))
}

private fun getElapsedTime(param: Long): String {
    return "[지난 시간: ${System.currentTimeMillis() - param}밀리초]"
}

suspend fun searchByKeywordV2(keyword: String): Array<String> = supervisorScope {
    val dbResultsDeferred = async(CoroutineName("DB 코루틴")) {
        throw Exception("DB 읽기 오류 발생")
        searchFromDB(keyword)
    }

    val serverResultsDeferred = async(CoroutineName("서버 코루틴")) {
        searchFromServer(keyword)
    }

    val dbResults = try {
        dbResultsDeferred.await()
    } catch (e: Exception) {
        arrayOf()
    }

    val serverResults = try {
        serverResultsDeferred.await()
    } catch (e: Exception) {
        arrayOf()
    }

    return@supervisorScope arrayOf(*dbResults, *serverResults)
}

private suspend fun searchFromDB(keyword: String): Array<String> {
    delay(1000L)
    return arrayOf("[DB]${keyword}1", "[DB]${keyword}2")
}

private suspend fun searchFromServer(keyword: String): Array<String> {
    delay(1000L)
    return arrayOf("[Server]${keyword}1", "[Server]${keyword}2")
}
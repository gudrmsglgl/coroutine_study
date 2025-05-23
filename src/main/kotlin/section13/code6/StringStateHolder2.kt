package section13.code6

import kotlinx.coroutines.*

class StringStateHolder2(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    private val coroutineScope = CoroutineScope(dispatcher)

    var stringState = ""
        private set

    fun updateStringWithDelay(string: String) {
        coroutineScope.launch {
            delay(1000L)
            stringState = string
        }
    }
}
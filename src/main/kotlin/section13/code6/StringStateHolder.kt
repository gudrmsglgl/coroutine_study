package section13.code6

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class StringStateHolder {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    var stringState = ""
        private set

    fun updateStringWithDelay(string: String) {
        coroutineScope.launch {
            delay(1000L)
            stringState = string
        }
    }
}
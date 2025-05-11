package section13.code3

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class RepeatAddUseCase {
    suspend fun add(repeatTime: Int): Int = withContext(Dispatchers.Default) {
        var result = 0
        repeat(repeatTime) {
            // case 2 if contain delay suspend function
            delay(100L)
            result += 1
        }
        return@withContext result
    }
}
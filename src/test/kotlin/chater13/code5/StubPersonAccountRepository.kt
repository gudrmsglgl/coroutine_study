package chater13.code5

import kotlinx.coroutines.delay
import section13.code5.Follower
import section13.code5.PersonAccountRepository

class StubPersonAccountRepository(
    private val users: List<Follower.PersonAccount>
) : PersonAccountRepository {
    override suspend fun searchByName(name: String): Array<Follower.PersonAccount> {
        delay(1000L)
        return users.filter { user ->
            user.name.contains(name)
        }.toTypedArray()
    }
}
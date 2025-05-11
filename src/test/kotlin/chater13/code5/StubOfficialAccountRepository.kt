package chater13.code5

import kotlinx.coroutines.delay
import section13.code5.Follower
import section13.code5.OfficialAccountRepository

class StubOfficialAccountRepository(
    private val users: List<Follower.OfficialAccount>
) : OfficialAccountRepository {
    override suspend fun searchByName(name: String): Array<Follower.OfficialAccount> {
        delay(1000L)
        return users.filter { user ->
            user.name.contains(name)
        }.toTypedArray()
    }
}
package section13.code5

interface PersonAccountRepository {
    suspend fun searchByName(name: String): Array<Follower.PersonAccount>
}
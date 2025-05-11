package section13.code5

interface OfficialAccountRepository {
    suspend fun searchByName(name: String): Array<Follower.OfficialAccount>
}
package section13.code2.stub

import section13.code2.UserNameRepository

class StubUserNameRepository(
    private val userNameMap: Map<String, String>
) : UserNameRepository {
    override fun saveUserName(id: String, name: String) {

    }

    override fun getNameByUserId(id: String): String {
        return userNameMap[id] ?: ""
    }
}
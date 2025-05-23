package section13.code2.fake

import section13.code2.UserPhoneNumberRepository

class FakeUserPhoneNumberRepository : UserPhoneNumberRepository {
    private val userPhoneNumberMap = mutableMapOf<String, String>()

    override fun saveUserPhoneNumber(id: String, phoneNumber: String) {
        userPhoneNumberMap[id] = phoneNumber
    }

    override fun getPhoneNumberByUserId(id: String): String {
        return userPhoneNumberMap[id] ?: ""
    }
}
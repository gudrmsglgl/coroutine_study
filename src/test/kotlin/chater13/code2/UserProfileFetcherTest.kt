package chater13.code2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import section13.code2.UserProfileFetcher
import section13.code2.fake.FakeUserPhoneNumberRepository
import section13.code2.stub.StubUserNameRepository

class UserProfileFetcherTest {
    @Test
    fun `UserNameRepotiory가 적절한 유저 프로필을 반환한다`() {
        // Given
        val userProfileFetcher = UserProfileFetcher(
            userNameRepository = StubUserNameRepository(
                userNameMap = mapOf(
                    "0x1111" to "홍길동",
                    "0x2222" to "김형근"
                )
            ),
            userPhoneNumberRepository = FakeUserPhoneNumberRepository().apply {
                this.saveUserPhoneNumber("0x1111", "010-xxxx-xxxx")
            }
        )
        // When
        val userProfile = userProfileFetcher.getUserProfileById(id = "0x1111")

        // Then
        assertEquals("홍길동", userProfile.name)
        assertEquals("010-xxxx-xxxx", userProfile.phoneNumber)
    }
}
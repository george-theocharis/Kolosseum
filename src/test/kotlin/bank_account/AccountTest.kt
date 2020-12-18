package bank_account

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class AccountTest {

    private val account = Account()

    @Test
    fun `deposit an amount`() {
        val result = account.deposit(1000)

        result shouldBe 1000
    }

}
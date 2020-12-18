package bank_account

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AccountTest {

    private val account = Account()

    @Test
    fun `deposit an amount`() {
        val result = account.deposit(1000)

        result shouldBe 1000
    }

    @Test
    fun `given an account with 1000, when withdrawing 1000, then result should be 0`() {
        account.deposit(1000)

        val result = account.withdraw(1000)

        result shouldBe 0
    }

    @Test
    fun `given an account with 500, when withdrawing 1000, then throw not viable transaction exception`() {
        account.deposit(500)

        assertThrows<NotViableTransactionException> { account.withdraw(1000) }
    }

}
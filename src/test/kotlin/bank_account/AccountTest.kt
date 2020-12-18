package bank_account

import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AccountTest {

    private val timeStamper: TimeStamper = mockk(relaxed = true)
    private val account = Account(timeStamper)

    @Test
    fun `given a zero balance account, depositing an amount, creates a transaction with amount and balance the same`() {
        every { timeStamper.addTimestamp() } returns "18/12/2020"

        val result = account.deposit(1000)

        result shouldBe Transaction(1000, 1000, "18/12/2020", Transaction.TransactionType.DEPOSIT)
    }

    @Test
    fun `given an account with 1000, when withdrawing 1000, then creates a transaction with zero balance`() {
        every { timeStamper.addTimestamp() } returns "18/12/2020"
        account.deposit(1000)

        val result = account.withdraw(1000)

        result shouldBe Transaction(1000, 0, "18/12/2020", Transaction.TransactionType.WITHDRAW)
    }

    @Test
    fun `given an account with 500, when withdrawing 1000, then throw not viable transaction exception`() {
        account.deposit(500)

        assertThrows<NotViableTransactionException> { account.withdraw(1000) }
    }

}
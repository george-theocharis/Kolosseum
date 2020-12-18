package bank_account

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.mockk.verifyOrder
import org.junit.jupiter.api.Test

internal class AccountServiceImplTest {

    private val account = mockk<Account>(relaxed = true)
    private val statementPrinter = mockk<StatementPrinter>(relaxed = true)
    private val accountServiceImpl = AccountServiceImpl(account, statementPrinter)

    @Test
    fun `deposit an amount`() {
        accountServiceImpl.deposit(1000)

        verify { account.deposit(1000) }
    }

    @Test
    fun `withdraw an amount`() {
        accountServiceImpl.withdraw(500)

        verify { account.withdraw(500) }
    }

    @Test
    fun `when printing statement, then print header`() {
        accountServiceImpl.printStatement()

        verify {
            statementPrinter.printHeader("Date       || Amount || Balance")
        }
    }

    @Test
    fun `when printing statement, then print all transactions`() {
        every { account.transactions } returns listOf(Transaction(amount = 1000, balance = 1000, date = "18/12/2020"))

        accountServiceImpl.printStatement()

        verify {
            statementPrinter.printTransaction("18/12/2020 || 1000   || 1000")
        }
    }

}
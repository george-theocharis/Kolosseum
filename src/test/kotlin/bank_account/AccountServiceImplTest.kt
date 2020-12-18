package bank_account

import io.mockk.mockk
import io.mockk.verify
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

}
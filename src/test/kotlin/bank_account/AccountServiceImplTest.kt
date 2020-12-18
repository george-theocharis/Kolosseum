package bank_account

import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

internal class AccountServiceImplTest {

    private val account = mockk<Account>(relaxed = true)
    private val statementPrinter = mockk<StatementPrinter>()
    private val accountServiceImpl = AccountServiceImpl(account, statementPrinter)


    @Test
    fun `deposit an amount`() {
        accountServiceImpl.deposit(1000)

        verify { account.deposit(1000) }
    }

}
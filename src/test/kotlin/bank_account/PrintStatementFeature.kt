package bank_account

import io.mockk.every
import io.mockk.mockk
import io.mockk.verifyOrder
import org.junit.jupiter.api.Test

class PrintStatementFeature {

    private val console = mockk<Console>(relaxed = true)
    private val timeStamper = mockk<TimeStamper>(relaxed = true)
    private val account = Account(timeStamper)
    private val statementPrinter = StatementPrinter(console)
    private val accountService = AccountServiceImpl(account, statementPrinter)

    @Test
    fun `account service should print bank statement`() {
        every { timeStamper.addTimestamp() } returns "10/01/2012"
        accountService.deposit(1000)
        every { timeStamper.addTimestamp() } returns "13/01/2012"
        accountService.deposit(2000)
        every { timeStamper.addTimestamp() } returns "14/01/2012"
        accountService.withdraw(500)

        accountService.printStatement()

        verifyOrder {
            statementPrinter.printHeader("Date       || Amount || Balance")
            statementPrinter.printTransaction("14/01/2012 || -500   || 2500")
            statementPrinter.printTransaction("13/01/2012 || 2000   || 3000")
            statementPrinter.printTransaction("10/01/2012 || 1000   || 1000")
        }
    }
}
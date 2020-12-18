package bank_account

import io.mockk.verifyOrder
import org.junit.jupiter.api.Test

class PrintStatementFeature {


    private val account = Account()
    private val statementPrinter = StatementPrinter()
    private val accountService = AccountServiceImpl(account, statementPrinter)

    @Test
    fun `account service should print bank statement`() {
        accountService.deposit(1000)
        accountService.deposit(2000)
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
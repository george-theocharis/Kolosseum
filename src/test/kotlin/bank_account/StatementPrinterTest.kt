package bank_account

import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class StatementPrinterTest {

    private val console =  mockk<Console>(relaxed = true)
    private val statementPrinter = StatementPrinter(console)

    @Test
    fun `when printing header, then print the header to the console`() {
        statementPrinter.printHeader("header")

        verify { console.print("header") }
    }

    @Test
    fun `when printing transaction, then print the transaction to the console`() {
        statementPrinter.printTransaction("transaction")

        verify { console.print("transaction") }
    }

}
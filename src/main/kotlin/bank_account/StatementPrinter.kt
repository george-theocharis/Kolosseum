package bank_account

class StatementPrinter(private val console: Console) {

    fun printHeader(header: String) {
        console.print(header)
    }

    fun printTransaction(transaction: String) {
        console.print(transaction)
    }

}

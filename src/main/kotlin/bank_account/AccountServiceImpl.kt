package bank_account

class AccountServiceImpl(
    private val account: Account,
    private val statementPrinter: StatementPrinter
) : AccountService {

    companion object {
        private const val STATEMENT_HEADER = "Date       || Amount || Balance"
    }

    override fun deposit(amount: Int) {
        account.deposit(amount)
    }

    override fun withdraw(amount: Int) {
        account.withdraw(amount)
    }

    override fun printStatement() {
        statementPrinter.printHeader(STATEMENT_HEADER)
        account.transactions
            .reversed()
            .forEach {
                statementPrinter.printTransaction(
                    "${it.date} || ${resolveType(it.type)}${it.amount}   || ${it.balance}"
                )
            }
    }

    private fun resolveType(type: Transaction.TransactionType): String {
        return when (type) {
            Transaction.TransactionType.WITHDRAW -> "-"
            else -> ""
        }
    }
}

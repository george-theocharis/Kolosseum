package bank_account

class AccountServiceImpl(
    private val account: Account,
    private val statementPrinter: StatementPrinter
) : AccountService {
    override fun deposit(amount: Int) {
        account.deposit(amount)
    }

    override fun withdraw(amount: Int) {
        account.withdraw(amount)
    }

    override fun printStatement() {
        TODO("Not yet implemented")
    }
}

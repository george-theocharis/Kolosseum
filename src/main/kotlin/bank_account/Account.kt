package bank_account

class Account(private val timeStamper: TimeStamper) {

    private var balance: Int = 0

    private val _transactions = mutableListOf<Transaction>()
    val transactions: List<Transaction> = _transactions

    fun deposit(amount: Int) = Transaction(
        amount = amount,
        balance = balance + amount,
        date = timeStamper.addTimestamp(),
        type = Transaction.TransactionType.DEPOSIT
    ).also {
        balance += amount
        _transactions.add(it)
    }

    fun withdraw(amount: Int): Transaction {
        if (balance - amount < 0) throw NotViableTransactionException()
        return Transaction(
            amount = amount,
            balance = balance - amount,
            date = timeStamper.addTimestamp(),
            type = Transaction.TransactionType.WITHDRAW
        ).also {
            balance -= amount
            _transactions.add(it)
        }
    }
}

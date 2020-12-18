package bank_account

class Account {
    private var total: Int = 0

    fun deposit(amount: Int): Int {
        total = amount
        return amount
    }

    fun withdraw(amount: Int): Int {
        if(total - amount < 0) throw NotViableTransactionException()
        return total - amount
    }
}

package bank_account

data class Transaction(
    val amount: Int,
    val balance: Int,
    val date: String,
    val type: TransactionType
) {
    enum class TransactionType {
        DEPOSIT, WITHDRAW
    }
}

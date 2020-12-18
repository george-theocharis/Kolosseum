package bank_account

interface AccountService {

    fun deposit(amount: Int)
    fun withdraw(amount: Int)
    fun printStatement()

}
class Bank(private val balance: LongArray) {
  private val n: Int

  init {
    n = balance.size
  }

  fun transfer(account1: Int, account2: Int, money: Long): Boolean {
    if (account1 > n || account2 > n || balance[account1 - 1] < money) {
      return false
    }
    balance[account1 - 1] -= money
    balance[account2 - 1] += money
    return true
  }

  fun deposit(account: Int, money: Long): Boolean {
    if (account > n) {
      return false
    }
    balance[account - 1] += money
    return true
  }

  fun withdraw(account: Int, money: Long): Boolean {
    if (account > n || balance[account - 1] < money) {
      return false
    }
    balance[account - 1] -= money
    return true
  }
}

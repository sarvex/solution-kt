import kotlin.math.min

class ATM {
  private val cnt = LongArray(5)
  private val d = intArrayOf(20, 50, 100, 200, 500)
  fun deposit(banknotesCount: IntArray) {
    for (i in banknotesCount.indices) {
      cnt[i] += banknotesCount[i].toLong()
    }
  }

  fun withdraw(amount: Int): IntArray {
    var amount = amount
    val ans = IntArray(5)
    for (i in 4 downTo 0) {
      ans[i] = min((amount / d[i]).toDouble(), cnt[i].toDouble()).toInt()
      amount -= ans[i] * d[i]
    }
    if (amount > 0) {
      return intArrayOf(-1)
    }
    for (i in 0..4) {
      cnt[i] -= ans[i].toLong()
    }
    return ans
  }
}

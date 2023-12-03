internal class Solution {
  fun numPrimeArrangements(n: Int): Int {
    val cnt = count(n)
    val ans = f(cnt) * f(n - cnt)
    return (ans % Solution.Companion.MOD).toInt()
  }

  private fun f(n: Int): Long {
    var ans: Long = 1
    for (i in 2..n) {
      ans = ans * i % Solution.Companion.MOD
    }
    return ans
  }

  private fun count(n: Int): Int {
    var cnt = 0
    val primes = BooleanArray(n + 1)
    Arrays.fill(primes, true)
    for (i in 2..n) {
      if (primes[i]) {
        ++cnt
        var j = i + i
        while (j <= n) {
          primes[j] = false
          j += i
        }
      }
    }
    return cnt
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}

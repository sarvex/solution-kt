internal class Solution {
  fun countPrimes(n: Int): Int {
    val primes = BooleanArray(n)
    Arrays.fill(primes, true)
    var ans = 0
    for (i in 2 until n) {
      if (primes[i]) {
        ++ans
        var j = i + i
        while (j < n) {
          primes[j] = false
          j += i
        }
      }
    }
    return ans
  }
}

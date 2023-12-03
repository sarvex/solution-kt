class Solution {
  fun findPrimePairs(n: Int): List<List<Int>> {
    val primes = BooleanArray(n)
    Arrays.fill(primes, true)
    for (i in 2 until n) {
      if (primes[i]) {
        var j = i + i
        while (j < n) {
          primes[j] = false
          j += i
        }
      }
    }
    val ans: List<List<Int>> = ArrayList()
    for (x in 2..n / 2) {
      val y = n - x
      if (primes[x] && primes[y]) {
        ans.add(List.of(x, y))
      }
    }
    return ans
  }
}

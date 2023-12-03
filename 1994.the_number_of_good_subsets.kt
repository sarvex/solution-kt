class Solution {
  fun numberOfGoodSubsets(nums: IntArray): Int {
    val primes = intArrayOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
    val cnt = IntArray(31)
    for (x in nums) {
      ++cnt[x]
    }
    val mod = 1e9.toInt() + 7
    val n = primes.size
    val f = LongArray(1 shl n)
    f[0] = 1
    for (i in 0 until cnt[1]) {
      f[0] = f[0] * 2 % mod
    }
    for (x in 2..30) {
      if (cnt[x] == 0 || x % 4 == 0 || x % 9 == 0 || x % 25 == 0) {
        continue
      }
      var mask = 0
      for (i in 0 until n) {
        if (x % primes[i] == 0) {
          mask = mask or (1 shl i)
        }
      }
      for (state in (1 shl n) - 1 downTo 1) {
        if (state and mask == mask) {
          f[state] = (f[state] + cnt[x] * f[state xor mask]) % mod
        }
      }
    }
    var ans: Long = 0
    for (i in 1 until (1 shl n)) {
      ans = (ans + f[i]) % mod
    }
    return ans.toInt()
  }
}

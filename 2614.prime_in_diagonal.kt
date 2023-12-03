import kotlin.math.max

class Solution {
  fun diagonalPrime(nums: Array<IntArray>): Int {
    val n = nums.size
    var ans = 0
    for (i in 0 until n) {
      if (isPrime(nums[i][i])) {
        ans = max(ans.toDouble(), nums[i][i].toDouble()).toInt()
      }
      if (isPrime(nums[i][n - i - 1])) {
        ans = max(ans.toDouble(), nums[i][n - i - 1].toDouble()).toInt()
      }
    }
    return ans
  }

  private fun isPrime(x: Int): Boolean {
    if (x < 2) {
      return false
    }
    for (i in 2..x / i) {
      if (x % i == 0) {
        return false
      }
    }
    return true
  }
}

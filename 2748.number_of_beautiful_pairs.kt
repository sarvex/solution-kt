class Solution {
  fun countBeautifulPairs(nums: IntArray): Int {
    val cnt = IntArray(10)
    var ans = 0
    for (x in nums) {
      for (y in 0..9) {
        if (cnt[y] > 0 && gcd(x % 10, y) == 1) {
          ans += cnt[y]
        }
      }
      while (x > 9) {
        x /= 10
      }
      ++cnt[x]
    }
    return ans
  }

  private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
  }
}

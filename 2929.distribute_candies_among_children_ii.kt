class Solution {
  fun distributeCandies(n: Int, limit: Int): Long {
    if (n > 3 * limit) {
      return 0
    }
    var ans = comb2(n + 2)
    if (n > limit) {
      ans -= 3 * comb2(n - limit + 1)
    }
    if (n - 2 >= 2 * limit) {
      ans += 3 * comb2(n - 2 * limit)
    }
    return ans
  }

  private fun comb2(n: Int): Long {
    return 1L * n * (n - 1) / 2
  }
}

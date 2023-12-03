class Solution {
  fun countDifferentSubsequenceGCDs(nums: IntArray): Int {
    val mx: Int = Arrays.stream(nums).max().getAsInt()
    val vis = BooleanArray(mx + 1)
    for (x in nums) {
      vis[x] = true
    }
    var ans = 0
    for (x in 1..mx) {
      var g = 0
      var y = x
      while (y <= mx) {
        if (vis[y]) {
          g = gcd(g, y)
          if (x == g) {
            ++ans
            break
          }
        }
        y += x
      }
    }
    return ans
  }

  private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
  }
}

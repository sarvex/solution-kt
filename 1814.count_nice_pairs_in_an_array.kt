class Solution {
  fun countNicePairs(nums: IntArray): Int {
    val cnt: Map<Int, Int> = HashMap()
    for (x in nums) {
      val y = x - rev(x)
      cnt.merge(y, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    val mod = 1e9.toInt() + 7
    var ans: Long = 0
    for (v in cnt.values()) {
      ans = (ans + v.toLong() * (v - 1) / 2) % mod
    }
    return ans.toInt()
  }

  private fun rev(x: Int): Int {
    var x = x
    var y = 0
    while (x > 0) {
      y = y * 10 + x % 10
      x /= 10
    }
    return y
  }
}

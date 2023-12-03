internal class Solution {
  fun numberOfArithmeticSlices(nums: IntArray): Int {
    val n = nums.size
    val f: Array<Map<Long, Int>?> = arrayOfNulls(n)
    Arrays.setAll(f) { k -> HashMap() }
    var ans = 0
    for (i in 0 until n) {
      for (j in 0 until i) {
        val d = 1L * nums[i] - nums[j]
        val cnt = f[j]!![d] ?: 0
        ans += cnt
        f[i].merge(d, cnt + 1) { a: Int, b: Int -> Integer.sum(a, b) }
      }
    }
    return ans
  }
}

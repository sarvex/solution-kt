class Solution {
  fun distance(nums: IntArray): LongArray {
    val n = nums.size
    val ans = LongArray(n)
    val d: Map<Int, List<Int>> = HashMap()
    for (i in 0 until n) {
      d.computeIfAbsent(nums[i]) { k -> ArrayList() }.add(i)
    }
    for (idx in d.values()) {
      val m: Int = idx.size()
      var left: Long = 0
      var right: Long = -1L * m * idx.get(0)
      for (i in idx) {
        right += i.toLong()
      }
      for (i in 0 until m) {
        ans[idx.get(i)] = left + right
        if (i + 1 < m) {
          left += (idx.get(i + 1) - idx.get(i)) * (i + 1L)
          right -= (idx.get(i + 1) - idx.get(i)) * (m - i - 1L)
        }
      }
    }
    return ans
  }
}

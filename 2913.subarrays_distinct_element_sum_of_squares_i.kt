class Solution {
  fun sumCounts(nums: List<Int?>): Int {
    var ans = 0
    val n: Int = nums.size()
    for (i in 0 until n) {
      val s = IntArray(101)
      var cnt = 0
      for (j in i until n) {
        if (++s[nums[j]!!] == 1) {
          ++cnt
        }
        ans += cnt * cnt
      }
    }
    return ans
  }
}

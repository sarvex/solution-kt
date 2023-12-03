internal class Solution {
  fun maxSubArrayLen(nums: IntArray, k: Int): Int {
    val d: Map<Long, Int> = HashMap()
    d.put(0L, -1)
    var ans = 0
    var s: Long = 0
    for (i in nums.indices) {
      s += nums[i].toLong()
      ans = Math.max(ans, i - (d[s - k] ?: i))
      d.putIfAbsent(s, i)
    }
    return ans
  }
}

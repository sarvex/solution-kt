internal class Solution {
  fun findShortestSubArray(nums: IntArray): Int {
    val cnt: Map<Int, Int> = HashMap()
    val left: Map<Int, Int> = HashMap()
    val right: Map<Int, Int> = HashMap()
    var degree = 0
    for (i in nums.indices) {
      val v = nums[i]
      cnt.put(v, (cnt[v] ?: 0) + 1)
      degree = Math.max(degree, cnt[v]!!)
      if (!left.containsKey(v)) {
        left.put(v, i)
      }
      right.put(v, i)
    }
    var ans = 1000000
    for (v in nums) {
      if (cnt[v] === degree) {
        val t = right[v]!! - left[v]!! + 1
        if (ans > t) {
          ans = t
        }
      }
    }
    return ans
  }
}

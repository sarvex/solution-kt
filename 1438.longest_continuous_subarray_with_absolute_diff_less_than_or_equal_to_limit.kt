import kotlin.math.max

class Solution {
  fun longestSubarray(nums: IntArray, limit: Int): Int {
    val tm: TreeMap<Int, Int> = TreeMap()
    var ans = 0
    var j = 0
    for (i in nums.indices) {
      tm.put(nums[i], tm.getOrDefault(nums[i], 0) + 1)
      while (tm.lastKey() - tm.firstKey() > limit) {
        tm.put(nums[j], tm.get(nums[j]) - 1)
        if (tm.get(nums[j]) === 0) {
          tm.remove(nums[j])
        }
        ++j
      }
      ans = max(ans.toDouble(), (i - j + 1).toDouble()).toInt()
    }
    return ans
  }
}

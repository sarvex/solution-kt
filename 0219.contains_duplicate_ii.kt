internal class Solution {
  fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    val d: Map<Int, Int> = HashMap()
    for (i in nums.indices) {
      if (i - (d[nums[i]] ?: -1000000) <= k) {
        return true
      }
      d.put(nums[i], i)
    }
    return false
  }
}

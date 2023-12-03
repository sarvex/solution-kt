class Solution {
  fun findSubarrays(nums: IntArray): Boolean {
    val vis: Set<Int> = HashSet()
    for (i in 1 until nums.size) {
      if (!vis.add(nums[i - 1] + nums[i])) {
        return true
      }
    }
    return false
  }
}

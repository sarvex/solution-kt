internal class Solution {
  fun containsNearbyAlmostDuplicate(nums: IntArray, indexDiff: Int, valueDiff: Int): Boolean {
    val ts: TreeSet<Long> = TreeSet()
    for (i in nums.indices) {
      val x: Long = ts.ceiling(nums[i].toLong() - valueDiff.toLong())
      if (x != null && x <= nums[i].toLong() + valueDiff.toLong()) {
        return true
      }
      ts.add(nums[i].toLong())
      if (i >= indexDiff) {
        ts.remove(nums[i - indexDiff].toLong())
      }
    }
    return false
  }
}

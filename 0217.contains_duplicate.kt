internal class Solution {
  fun containsDuplicate(nums: IntArray): Boolean {
    val s: Set<Int> = HashSet()
    for (num in nums) {
      if (!s.add(num)) {
        return true
      }
    }
    return false
  }
}

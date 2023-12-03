class Solution {
  fun repeatedNTimes(nums: IntArray): Int {
    val s: Set<Int> = HashSet(nums.size / 2 + 1)
    var i = 0
    while (true) {
      if (!s.add(nums[i])) {
        return nums[i]
      }
      ++i
    }
  }
}

class Solution {
  fun maxNonOverlapping(nums: IntArray, target: Int): Int {
    var i = 0
    val n = nums.size
    var ans = 0
    while (i < n) {
      var s = 0
      val seen: Set<Int> = HashSet()
      seen.add(0)
      while (i < n) {
        s += nums[i]
        if (seen.contains(s - target)) {
          ++ans
          break
        }
        ++i
        seen.add(s)
      }
      ++i
    }
    return ans
  }
}

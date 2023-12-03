internal class Solution {
  fun splitArraySameAverage(nums: IntArray): Boolean {
    val n = nums.size
    if (n == 1) {
      return false
    }
    val s: Int = Arrays.stream(nums).sum()
    for (i in 0 until n) {
      nums[i] = nums[i] * n - s
    }
    val m = n shr 1
    val vis: Set<Int> = HashSet()
    for (i in 1 until (1 shl m)) {
      var t = 0
      for (j in 0 until m) {
        if (i shr j and 1 == 1) {
          t += nums[j]
        }
      }
      if (t == 0) {
        return true
      }
      vis.add(t)
    }
    for (i in 1 until (1 shl n - m)) {
      var t = 0
      for (j in 0 until n - m) {
        if (i shr j and 1 == 1) {
          t += nums[m + j]
        }
      }
      if (t == 0 || i != (1 shl n - m) - 1 && vis.contains(-t)) {
        return true
      }
    }
    return false
  }
}

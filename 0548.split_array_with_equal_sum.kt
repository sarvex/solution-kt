internal class Solution {
  fun splitArray(nums: IntArray): Boolean {
    val n = nums.size
    val s = IntArray(n + 1)
    for (i in 0 until n) {
      s[i + 1] = s[i] + nums[i]
    }
    for (j in 3 until n - 3) {
      val seen: Set<Int> = HashSet()
      for (i in 1 until j - 1) {
        if (s[i] == s[j] - s[i + 1]) {
          seen.add(s[i])
        }
      }
      for (k in j + 2 until n - 1) {
        if (s[n] - s[k + 1] == s[k] - s[j + 1] && seen.contains(s[n] - s[k + 1])) {
          return true
        }
      }
    }
    return false
  }
}

class Solution {
  fun distinctDifferenceArray(nums: IntArray): IntArray {
    val n = nums.size
    val suf = IntArray(n + 1)
    val s: Set<Int> = HashSet()
    for (i in n - 1 downTo 0) {
      s.add(nums[i])
      suf[i] = s.size()
    }
    s.clear()
    val ans = IntArray(n)
    for (i in 0 until n) {
      s.add(nums[i])
      ans[i] = s.size() - suf[i + 1]
    }
    return ans
  }
}

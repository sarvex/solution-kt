class Solution {
  fun distinctNumbers(nums: IntArray, k: Int): IntArray {
    val cnt = IntArray(100010)
    var x = 0
    for (i in 0 until k) {
      if (cnt[nums[i]]++ == 0) {
        ++x
      }
    }
    val n = nums.size
    val ans = IntArray(n - k + 1)
    ans[0] = x
    for (i in k until n) {
      if (--cnt[nums[i - k]] == 0) {
        --x
      }
      if (cnt[nums[i]]++ == 0) {
        ++x
      }
      ans[i - k + 1] = x
    }
    return ans
  }
}

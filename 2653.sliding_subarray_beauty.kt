class Solution {
  fun getSubarrayBeauty(nums: IntArray, k: Int, x: Int): IntArray {
    val n = nums.size
    val cnt = IntArray(101)
    for (i in 0 until k) {
      ++cnt[nums[i] + 50]
    }
    val ans = IntArray(n - k + 1)
    ans[0] = f(cnt, x)
    var i = k
    var j = 1
    while (i < n) {
      ++cnt[nums[i] + 50]
      --cnt[nums[i - k] + 50]
      ans[j++] = f(cnt, x)
      ++i
    }
    return ans
  }

  private fun f(cnt: IntArray, x: Int): Int {
    var s = 0
    for (i in 0..49) {
      s += cnt[i]
      if (s >= x) {
        return i - 50
      }
    }
    return 0
  }
}

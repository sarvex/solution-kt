class Solution {
  private var nums: IntArray
  private val cnt = IntArray(1010)
  private var ans = -1
  private var k = 0
  fun beautifulSubsets(nums: IntArray, k: Int): Int {
    this.k = k
    this.nums = nums
    dfs(0)
    return ans
  }

  private fun dfs(i: Int) {
    if (i >= nums.size) {
      ++ans
      return
    }
    dfs(i + 1)
    val ok1 = nums[i] + k >= cnt.size || cnt[nums[i] + k] == 0
    val ok2 = nums[i] - k < 0 || cnt[nums[i] - k] == 0
    if (ok1 && ok2) {
      ++cnt[nums[i]]
      dfs(i + 1)
      --cnt[nums[i]]
    }
  }
}

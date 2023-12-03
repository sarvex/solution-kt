class Solution {
  fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
    val cnt = IntArray(102)
    for (x in nums) {
      ++cnt[x + 1]
    }
    for (i in 1 until cnt.size) {
      cnt[i] += cnt[i - 1]
    }
    val n = nums.size
    val ans = IntArray(n)
    for (i in 0 until n) {
      ans[i] = cnt[nums[i]]
    }
    return ans
  }
}

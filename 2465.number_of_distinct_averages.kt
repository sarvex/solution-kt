class Solution {
  fun distinctAverages(nums: IntArray): Int {
    Arrays.sort(nums)
    val cnt = IntArray(201)
    val n = nums.size
    var ans = 0
    for (i in 0 until (n shr 1)) {
      if (++cnt[nums[i] + nums[n - i - 1]] == 1) {
        ++ans
      }
    }
    return ans
  }
}

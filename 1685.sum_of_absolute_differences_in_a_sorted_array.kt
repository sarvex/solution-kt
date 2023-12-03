class Solution {
  fun getSumAbsoluteDifferences(nums: IntArray): IntArray {
    // int s = Arrays.stream(nums).sum();
    var s = 0
    var t = 0
    for (x in nums) {
      s += x
    }
    val n = nums.size
    val ans = IntArray(n)
    for (i in 0 until n) {
      val v = nums[i] * i - t + s - t - nums[i] * (n - i)
      ans[i] = v
      t += nums[i]
    }
    return ans
  }
}

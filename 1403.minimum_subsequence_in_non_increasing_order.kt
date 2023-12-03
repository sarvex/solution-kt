class Solution {
  fun minSubsequence(nums: IntArray): List<Int> {
    Arrays.sort(nums)
    val ans: List<Int> = ArrayList()
    val s: Int = Arrays.stream(nums).sum()
    var t = 0
    for (i in nums.indices.reversed()) {
      t += nums[i]
      ans.add(nums[i])
      if (t > s - t) {
        break
      }
    }
    return ans
  }
}

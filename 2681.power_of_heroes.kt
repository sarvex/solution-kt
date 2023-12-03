class Solution {
  fun sumOfPower(nums: IntArray): Int {
    val mod = 1e9.toInt() + 7
    Arrays.sort(nums)
    var ans: Long = 0
    var p: Long = 0
    for (i in nums.indices.reversed()) {
      val x = nums[i].toLong()
      ans = (ans + x * x % mod * x) % mod
      ans = (ans + x * p % mod) % mod
      p = (p * 2 + x * x % mod) % mod
    }
    return ans.toInt()
  }
}

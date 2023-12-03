class Solution {
  fun numSubseq(nums: IntArray, target: Int): Int {
    Arrays.sort(nums)
    val mod = 1e9.toInt() + 7
    val n = nums.size
    val f = IntArray(n + 1)
    f[0] = 1
    for (i in 1..n) {
      f[i] = f[i - 1] * 2 % mod
    }
    var ans = 0
    for (i in 0 until n) {
      if (nums[i] * 2L > target) {
        break
      }
      val j = search(nums, target - nums[i], i + 1) - 1
      ans = (ans + f[j - i]) % mod
    }
    return ans
  }

  private fun search(nums: IntArray, x: Int, left: Int): Int {
    var left = left
    var right = nums.size
    while (left < right) {
      val mid = left + right shr 1
      if (nums[mid] > x) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }
}

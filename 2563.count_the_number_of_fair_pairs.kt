class Solution {
  fun countFairPairs(nums: IntArray, lower: Int, upper: Int): Long {
    Arrays.sort(nums)
    var ans: Long = 0
    val n = nums.size
    for (i in 0 until n) {
      val j = search(nums, lower - nums[i], i + 1)
      val k = search(nums, upper - nums[i] + 1, i + 1)
      ans += (k - j).toLong()
    }
    return ans
  }

  private fun search(nums: IntArray, x: Int, left: Int): Int {
    var left = left
    var right = nums.size
    while (left < right) {
      val mid = left + right shr 1
      if (nums[mid] >= x) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }
}

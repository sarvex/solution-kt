internal class Solution {
  fun smallestDistancePair(nums: IntArray, k: Int): Int {
    Arrays.sort(nums)
    var left = 0
    var right = nums[nums.size - 1] - nums[0]
    while (left < right) {
      val mid = left + right shr 1
      if (count(mid, nums) >= k) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }

  private fun count(dist: Int, nums: IntArray): Int {
    var cnt = 0
    for (i in nums.indices) {
      var left = 0
      var right = i
      while (left < right) {
        val mid = left + right shr 1
        val target = nums[i] - dist
        if (nums[mid] >= target) {
          right = mid
        } else {
          left = mid + 1
        }
      }
      cnt += i - left
    }
    return cnt
  }
}

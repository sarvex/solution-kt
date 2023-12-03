class Solution {
  fun specialArray(nums: IntArray): Int {
    Arrays.sort(nums)
    val n = nums.size
    for (x in 1..n) {
      var left = 0
      var right = n
      while (left < right) {
        val mid = left + right shr 1
        if (nums[mid] >= x) {
          right = mid
        } else {
          left = mid + 1
        }
      }
      val cnt = n - left
      if (cnt == x) {
        return x
      }
    }
    return -1
  }
}

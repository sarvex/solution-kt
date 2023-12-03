class Solution {
  fun countPairs(nums: List<Int>, target: Int): Int {
    Collections.sort(nums)
    var ans = 0
    for (j in 0 until nums.size()) {
      val x = nums[j]
      val i = search(nums, target - x, j)
      ans += i
    }
    return ans
  }

  private fun search(nums: List<Int>, x: Int, r: Int): Int {
    var r = r
    var l = 0
    while (l < r) {
      val mid = l + r shr 1
      if (nums[mid] >= x) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l
  }
}

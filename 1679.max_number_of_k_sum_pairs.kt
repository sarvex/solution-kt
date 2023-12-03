class Solution {
  fun maxOperations(nums: IntArray, k: Int): Int {
    Arrays.sort(nums)
    var l = 0
    var r = nums.size - 1
    var ans = 0
    while (l < r) {
      val s = nums[l] + nums[r]
      if (s == k) {
        ++ans
        ++l
        --r
      } else if (s > k) {
        --r
      } else {
        ++l
      }
    }
    return ans
  }
}

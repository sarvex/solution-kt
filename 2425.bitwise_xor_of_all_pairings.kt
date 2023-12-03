class Solution {
  fun xorAllNums(nums1: IntArray, nums2: IntArray): Int {
    var ans = 0
    if (nums2.size % 2 == 1) {
      for (v in nums1) {
        ans = ans xor v
      }
    }
    if (nums1.size % 2 == 1) {
      for (v in nums2) {
        ans = ans xor v
      }
    }
    return ans
  }
}

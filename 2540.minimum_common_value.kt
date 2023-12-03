class Solution {
  fun getCommon(nums1: IntArray, nums2: IntArray): Int {
    val m = nums1.size
    val n = nums2.size
    var i = 0
    var j = 0
    while (i < m && j < n) {
      if (nums1[i] == nums2[j]) {
        return nums1[i]
      }
      if (nums1[i] < nums2[j]) {
        ++i
      } else {
        ++j
      }
    }
    return -1
  }
}

class Solution {
  fun minProductSum(nums1: IntArray, nums2: IntArray): Int {
    Arrays.sort(nums1)
    Arrays.sort(nums2)
    val n = nums1.size
    var res = 0
    for (i in 0 until n) {
      res += nums1[i] * nums2[n - i - 1]
    }
    return res
  }
}

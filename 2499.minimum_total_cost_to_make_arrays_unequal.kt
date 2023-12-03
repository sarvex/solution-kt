class Solution {
  fun minimumTotalCost(nums1: IntArray, nums2: IntArray): Long {
    var ans: Long = 0
    var same = 0
    val n = nums1.size
    val cnt = IntArray(n + 1)
    for (i in 0 until n) {
      if (nums1[i] == nums2[i]) {
        ans += i.toLong()
        ++same
        ++cnt[nums1[i]]
      }
    }
    var m = 0
    var lead = 0
    for (i in cnt.indices) {
      val t = cnt[i] * 2 - same
      if (t > 0) {
        m = t
        lead = i
        break
      }
    }
    for (i in 0 until n) {
      if (m > 0 && nums1[i] != nums2[i] && nums1[i] != lead && nums2[i] != lead) {
        ans += i.toLong()
        --m
      }
    }
    return if (m > 0) -1 else ans
  }
}

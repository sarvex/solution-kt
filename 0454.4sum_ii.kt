internal class Solution {
  fun fourSumCount(nums1: IntArray, nums2: IntArray, nums3: IntArray, nums4: IntArray): Int {
    val cnt: Map<Int, Int> = HashMap()
    for (a in nums1) {
      for (b in nums2) {
        cnt.merge(a + b, 1) { a: Int, b: Int -> Integer.sum(a, b) }
      }
    }
    var ans = 0
    for (c in nums3) {
      for (d in nums4) {
        ans += cnt[-(c + d)] ?: 0
      }
    }
    return ans
  }
}

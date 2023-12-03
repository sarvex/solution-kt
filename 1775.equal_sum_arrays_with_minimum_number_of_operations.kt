class Solution {
  fun minOperations(nums1: IntArray, nums2: IntArray): Int {
    val s1: Int = Arrays.stream(nums1).sum()
    val s2: Int = Arrays.stream(nums2).sum()
    if (s1 == s2) {
      return 0
    }
    if (s1 > s2) {
      return minOperations(nums2, nums1)
    }
    var d = s2 - s1
    val cnt = IntArray(6)
    for (v in nums1) {
      ++cnt[6 - v]
    }
    for (v in nums2) {
      ++cnt[v - 1]
    }
    var ans = 0
    for (i in 5 downTo 1) {
      while (cnt[i] > 0 && d > 0) {
        d -= i
        --cnt[i]
        ++ans
      }
    }
    return if (d <= 0) ans else -1
  }
}

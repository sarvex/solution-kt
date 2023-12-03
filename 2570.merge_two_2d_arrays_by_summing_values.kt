class Solution {
  fun mergeArrays(nums1: Array<IntArray>, nums2: Array<IntArray>): Array<IntArray> {
    val cnt = IntArray(1001)
    for (x in nums1) {
      cnt[x[0]] += x[1]
    }
    for (x in nums2) {
      cnt[x[0]] += x[1]
    }
    var n = 0
    for (i in 0..1000) {
      if (cnt[i] > 0) {
        ++n
      }
    }
    val ans = Array(n) { IntArray(2) }
    var i = 0
    var j = 0
    while (i < 1001) {
      if (cnt[i] > 0) {
        ans[j++] = intArrayOf(i, cnt[i])
      }
      ++i
    }
    return ans
  }
}

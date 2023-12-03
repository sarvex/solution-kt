internal class Solution {
  fun advantageCount(nums1: IntArray, nums2: IntArray): IntArray {
    val n = nums1.size
    val t = Array(n) { IntArray(2) }
    for (i in 0 until n) {
      t[i] = intArrayOf(nums2[i], i)
    }
    Arrays.sort(t) { a, b -> a.get(0) - b.get(0) }
    Arrays.sort(nums1)
    val ans = IntArray(n)
    var i = 0
    var j = n - 1
    for (v in nums1) {
      if (v <= t[i][0]) {
        ans[t[j--][1]] = v
      } else {
        ans[t[i++][1]] = v
      }
    }
    return ans
  }
}

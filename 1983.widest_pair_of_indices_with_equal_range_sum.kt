class Solution {
  fun widestPairOfIndices(nums1: IntArray, nums2: IntArray): Int {
    val d: Map<Int, Int> = HashMap()
    d.put(0, -1)
    val n = nums1.size
    var s = 0
    var ans = 0
    for (i in 0 until n) {
      s += nums1[i] - nums2[i]
      if (d.containsKey(s)) {
        ans = Math.max(ans, i - d[s]!!)
      } else {
        d.put(s, i)
      }
    }
    return ans
  }
}

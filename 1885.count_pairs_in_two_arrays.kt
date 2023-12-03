class Solution {
  fun countPairs(nums1: IntArray, nums2: IntArray): Long {
    val n = nums1.size
    val d = IntArray(n)
    for (i in 0 until n) {
      d[i] = nums1[i] - nums2[i]
    }
    Arrays.sort(d)
    var ans: Long = 0
    for (i in 0 until n) {
      var left = i + 1
      var right = n
      while (left < right) {
        val mid = left + right shr 1
        if (d[mid] > -d[i]) {
          right = mid
        } else {
          left = mid + 1
        }
      }
      ans += (n - left).toLong()
    }
    return ans
  }
}

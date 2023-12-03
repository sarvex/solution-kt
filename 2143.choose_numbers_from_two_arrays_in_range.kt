internal class Solution {
  fun countSubranges(nums1: IntArray, nums2: IntArray): Int {
    val n = nums1.size
    val s1: Int = Arrays.stream(nums1).sum()
    val s2: Int = Arrays.stream(nums2).sum()
    val f = Array(n) { IntArray(s1 + s2 + 1) }
    var ans = 0
    val mod = 1e9.toInt() + 7
    for (i in 0 until n) {
      val a = nums1[i]
      val b = nums2[i]
      f[i][a + s2]++
      f[i][-b + s2]++
      if (i > 0) {
        for (j in 0..s1 + s2) {
          if (j >= a) {
            f[i][j] = (f[i][j] + f[i - 1][j - a]) % mod
          }
          if (j + b <= s1 + s2) {
            f[i][j] = (f[i][j] + f[i - 1][j + b]) % mod
          }
        }
      }
      ans = (ans + f[i][s2]) % mod
    }
    return ans
  }
}

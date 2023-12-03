internal class Solution {
  fun bestRotation(nums: IntArray): Int {
    val n = nums.size
    val d = IntArray(n)
    for (i in 0 until n) {
      val l = (i + 1) % n
      val r = (n + i + 1 - nums[i]) % n
      ++d[l]
      --d[r]
    }
    var mx = -1
    var s = 0
    var ans = n
    for (k in 0 until n) {
      s += d[k]
      if (s > mx) {
        mx = s
        ans = k
      }
    }
    return ans
  }
}

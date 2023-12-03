internal class Solution {
  fun minimumDifference(nums: IntArray): Int {
    val n = nums.size shr 1
    val f: Map<Int, Set<Int>> = HashMap()
    val g: Map<Int, Set<Int>> = HashMap()
    for (i in 0 until (1 shl n)) {
      var s = 0
      var cnt = 0
      var s1 = 0
      var cnt1 = 0
      for (j in 0 until n) {
        if (i and (1 shl j) != 0) {
          s += nums[j]
          ++cnt
          s1 += nums[n + j]
          ++cnt1
        } else {
          s -= nums[j]
          s1 -= nums[n + j]
        }
      }
      f.computeIfAbsent(cnt) { k -> HashSet() }.add(s)
      g.computeIfAbsent(cnt1) { k -> HashSet() }.add(s1)
    }
    var ans = Int.MAX_VALUE
    for (i in 0..n) {
      val fi: List<Int> = ArrayList(f[i])
      val gi: List<Int> = ArrayList(g[n - i])
      Collections.sort(fi)
      Collections.sort(gi)
      for (a in fi) {
        var left = 0
        var right: Int = gi.size() - 1
        val b = -a
        while (left < right) {
          val mid = left + right shr 1
          if (gi[mid] >= b) {
            right = mid
          } else {
            left = mid + 1
          }
        }
        ans = Math.min(ans, Math.abs(a + gi[left]))
        if (left > 0) {
          ans = Math.min(ans, Math.abs(a + gi[left - 1]))
        }
      }
    }
    return ans
  }
}

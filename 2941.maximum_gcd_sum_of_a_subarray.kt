import kotlin.math.max

class Solution {
  fun maxGcdSum(nums: IntArray, k: Int): Long {
    val n = nums.size
    val s = LongArray(n + 1)
    for (i in 1..n) {
      s[i] = s[i - 1] + nums[i - 1]
    }
    var f: List<IntArray> = ArrayList()
    var ans: Long = 0
    for (i in 0 until n) {
      val g: List<IntArray> = ArrayList()
      for (e in f) {
        val j = e[0]
        val x = e[1]
        val y = gcd(x, nums[i])
        if (g.isEmpty() || g[g.size() - 1][1] !== y) {
          g.add(intArrayOf(j, y))
        }
      }
      f = g
      f.add(intArrayOf(i, nums[i]))
      for (e in f) {
        val j = e[0]
        val x = e[1]
        if (i - j + 1 >= k) {
          ans = max(ans.toDouble(), ((s[i + 1] - s[j]) * x).toDouble()).toLong()
        }
      }
    }
    return ans
  }

  private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
  }
}

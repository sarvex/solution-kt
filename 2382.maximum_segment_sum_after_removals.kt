import kotlin.math.max

class Solution {
  private var p: IntArray
  private var s: LongArray
  fun maximumSegmentSum(nums: IntArray, removeQueries: IntArray): LongArray {
    val n = nums.size
    p = IntArray(n)
    s = LongArray(n)
    for (i in 0 until n) {
      p[i] = i
    }
    val ans = LongArray(n)
    var mx: Long = 0
    for (j in n - 1 downTo 1) {
      val i = removeQueries[j]
      s[i] = nums[i].toLong()
      if (i > 0 && s[find(i - 1)] > 0) {
        merge(i, i - 1)
      }
      if (i < n - 1 && s[find(i + 1)] > 0) {
        merge(i, i + 1)
      }
      mx = max(mx.toDouble(), s[find(i)].toDouble()).toLong()
      ans[j - 1] = mx
    }
    return ans
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }

  private fun merge(a: Int, b: Int) {
    val pa = find(a)
    val pb = find(b)
    p[pa] = pb
    s[pb] += s[pa]
  }
}

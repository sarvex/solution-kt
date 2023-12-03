import kotlin.math.max

class UnionFind(n: Int) {
  @JvmField
  var p: IntArray

  init {
    p = IntArray(n)
    for (i in 0 until n) {
      p[i] = i
    }
  }

  fun union(a: Int, b: Int) {
    val pa = find(a)
    val pb = find(b)
    if (pa != pb) {
      p[pa] = pb
    }
  }

  fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }
}

internal class Solution {
  fun largestComponentSize(nums: IntArray): Int {
    var m = 0
    for (v in nums) {
      m = max(m.toDouble(), v.toDouble()).toInt()
    }
    val uf = UnionFind(m + 1)
    for (v in nums) {
      var i = 2
      while (i <= v / i) {
        if (v % i == 0) {
          uf.union(v, i)
          uf.union(v, v / i)
        }
        ++i
      }
    }
    val cnt = IntArray(m + 1)
    var ans = 0
    for (v in nums) {
      val t = uf.find(v)
      ++cnt[t]
      ans = max(ans.toDouble(), cnt[t].toDouble()).toInt()
    }
    return ans
  }
}

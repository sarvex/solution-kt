class UnionFind(n: Int) {
  private val p: IntArray
  private val size: IntArray

  init {
    p = IntArray(n)
    size = IntArray(n)
    for (i in 0 until n) {
      p[i] = i
      size[i] = 1
    }
  }

  fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }

  fun union(a: Int, b: Int): Boolean {
    val pa = find(a)
    val pb = find(b)
    if (pa == pb) {
      return false
    }
    if (size[pa] > size[pb]) {
      p[pb] = pa
      size[pa] += size[pb]
    } else {
      p[pa] = pb
      size[pb] += size[pa]
    }
    return true
  }
}

internal class Solution {
  fun canTraverseAllPairs(nums: IntArray): Boolean {
    val m: Int = Arrays.stream(nums).max().getAsInt()
    val n = nums.size
    val uf = UnionFind(n + m + 1)
    for (i in 0 until n) {
      for (j in Solution.Companion.P.get(nums[i])) {
        uf.union(i, j + n)
      }
    }
    val s: Set<Int> = HashSet()
    for (i in 0 until n) {
      s.add(uf.find(i))
    }
    return s.size() === 1
  }

  companion object {
    private const val MX = 100010
    private val P: Array<List<Int>?> = arrayOfNulls<List>(Solution.Companion.MX)

    init {
      Arrays.setAll(Solution.Companion.P) { k -> ArrayList() }
      for (x in 1 until Solution.Companion.MX) {
        var v = x
        var i = 2
        while (i <= v / i) {
          if (v % i == 0) {
            Solution.Companion.P.get(x).add(i)
            while (v % i == 0) {
              v /= i
            }
          }
          ++i
        }
        if (v > 1) {
          Solution.Companion.P.get(x).add(v)
        }
      }
    }
  }
}

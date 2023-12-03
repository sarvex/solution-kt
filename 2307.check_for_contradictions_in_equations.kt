import kotlin.math.abs

class Solution {
  private var p: IntArray
  private var w: DoubleArray
  fun checkContradictions(equations: List<List<String?>>, values: DoubleArray): Boolean {
    val d: Map<String?, Int> = HashMap()
    var n = 0
    for (e in equations) {
      for (s in e) {
        if (!d.containsKey(s)) {
          d.put(s, n++)
        }
      }
    }
    p = IntArray(n)
    w = DoubleArray(n)
    for (i in 0 until n) {
      p[i] = i
      w[i] = 1.0
    }
    val eps = 1e-5
    for (i in 0 until equations.size()) {
      val a = d[equations[i][0]]!!
      val b = d[equations[i][1]]!!
      val pa = find(a)
      val pb = find(b)
      val v = values[i]
      if (pa != pb) {
        p[pb] = pa
        w[pb] = v * w[a] / w[b]
      } else if (abs(v * w[a] - w[b]) >= eps) {
        return true
      }
    }
    return false
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      val root = find(p[x])
      w[x] *= w[p[x]]
      p[x] = root
    }
    return p[x]
  }
}

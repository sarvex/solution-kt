internal class Solution {
  private var p: Map<String?, String?>? = null
  private var w: Map<String?, Double>? = null
  fun calcEquation(
    equations: List<List<String?>>, values: DoubleArray, queries: List<List<String?>>
  ): DoubleArray {
    val n: Int = equations.size()
    p = HashMap()
    w = HashMap()
    for (e in equations) {
      p.put(e[0], e[0])
      p.put(e[1], e[1])
      w.put(e[0], 1.0)
      w.put(e[1], 1.0)
    }
    for (i in 0 until n) {
      val e = equations[i]
      val a = e[0]
      val b = e[1]
      val pa = find(a)
      val pb = find(b)
      if (Objects.equals(pa, pb)) {
        continue
      }
      p.put(pa, pb)
      w.put(pa, w.get(b)!! * values[i] / w.get(a)!!)
    }
    val m: Int = queries.size()
    val ans = DoubleArray(m)
    for (i in 0 until m) {
      val c = queries[i][0]
      val d = queries[i][1]
      ans[i] = if (!p.containsKey(c) || !p.containsKey(d) || !Objects.equals(
          find(c),
          find(d)
        )
      ) -1.0 else w.get(c)!! / w.get(d)!!
    }
    return ans
  }

  private fun find(x: String?): String? {
    if (!Objects.equals(p!![x], x)) {
      val origin = p!![x]
      p.put(x, find(p!![x]))
      w.put(x, w!![x]!! * w!![origin]!!)
    }
    return p!![x]
  }
}

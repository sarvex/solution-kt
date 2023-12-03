class Solution {
  private var p: IntArray
  fun distanceLimitedPathsExist(n: Int, edgeList: Array<IntArray>, queries: Array<IntArray>): BooleanArray {
    p = IntArray(n)
    for (i in 0 until n) {
      p[i] = i
    }
    Arrays.sort(edgeList) { a, b -> a.get(2) - b.get(2) }
    val m = queries.size
    val ans = BooleanArray(m)
    val qid = arrayOfNulls<Int>(m)
    for (i in 0 until m) {
      qid[i] = i
    }
    Arrays.sort(qid) { i, j -> queries[i][2] - queries[j][2] }
    var j = 0
    for (i in qid) {
      val a = queries[i][0]
      val b = queries[i][1]
      val limit = queries[i][2]
      while (j < edgeList.size && edgeList[j][2] < limit) {
        val u = edgeList[j][0]
        val v = edgeList[j][1]
        p[find(u)] = find(v)
        ++j
      }
      ans[i] = find(a) == find(b)
    }
    return ans
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }
}

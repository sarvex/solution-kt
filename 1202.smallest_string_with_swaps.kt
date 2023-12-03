internal class Solution {
  private var p: IntArray
  fun smallestStringWithSwaps(s: String, pairs: List<List<Int?>>): String {
    val n = s.length
    p = IntArray(n)
    val d: Array<List<Char>?> = arrayOfNulls(n)
    for (i in 0 until n) {
      p[i] = i
      d[i] = ArrayList()
    }
    for (pair in pairs) {
      val a: Int = pair[0]
      val b: Int = pair[1]
      p[find(a)] = find(b)
    }
    val cs = s.toCharArray()
    for (i in 0 until n) {
      d[find(i)].add(cs[i])
    }
    for (e in d) {
      e.sort { a, b -> b - a }
    }
    for (i in 0 until n) {
      val e = d[find(i)]
      cs[i] = e.remove(e!!.size() - 1)
    }
    return String(cs)
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }
}

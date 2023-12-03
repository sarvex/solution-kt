class Solution {
  fun peopleIndexes(favoriteCompanies: List<List<String?>>): List<Int> {
    val d: Map<String, Int> = HashMap()
    var idx = 0
    val n: Int = favoriteCompanies.size()
    val t: Array<Set<Int>?> = arrayOfNulls(n)
    for (i in 0 until n) {
      val v: Unit = favoriteCompanies[i]
      for (c in v) {
        if (!d.containsKey(c)) {
          d.put(c, idx++)
        }
      }
      val s: Set<Int> = HashSet()
      for (c in v) {
        s.add(d[c])
      }
      t[i] = s
    }
    val ans: List<Int> = ArrayList()
    for (i in 0 until n) {
      var ok = true
      for (j in 0 until n) {
        if (i != j) {
          if (t[j]!!.containsAll(t[i]!!)) {
            ok = false
            break
          }
        }
      }
      if (ok) {
        ans.add(i)
      }
    }
    return ans
  }
}

class Solution {
  fun findWinners(matches: Array<IntArray>): List<List<Int>> {
    val cnt: Map<Int, Int> = HashMap()
    for (m in matches) {
      val a = m[0]
      val b = m[1]
      cnt.putIfAbsent(a, 0)
      cnt.put(b, (cnt[b] ?: 0) + 1)
    }
    val ans: List<List<Int>> = ArrayList()
    ans.add(ArrayList())
    ans.add(ArrayList())
    for (entry in cnt.entrySet()) {
      val u: Int = entry.getKey()
      val v: Int = entry.getValue()
      if (v < 2) {
        ans[v].add(u)
      }
    }
    Collections.sort(ans[0])
    Collections.sort(ans[1])
    return ans
  }
}

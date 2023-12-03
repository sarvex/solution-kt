class Solution {
  fun findingUsersActiveMinutes(logs: Array<IntArray>, k: Int): IntArray {
    val d: Map<Int, Set<Int>> = HashMap()
    for (log in logs) {
      val i = log[0]
      val t = log[1]
      d.computeIfAbsent(i) { key -> HashSet() }.add(t)
    }
    val ans = IntArray(k)
    for (ts in d.values()) {
      ++ans[ts.size() - 1]
    }
    return ans
  }
}

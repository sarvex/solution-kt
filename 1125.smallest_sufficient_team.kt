internal class Solution {
  fun smallestSufficientTeam(req_skills: Array<String?>, people: List<List<String>>): IntArray {
    val d: Map<String, Int> = HashMap()
    val m = req_skills.size
    val n: Int = people.size()
    for (i in 0 until m) {
      d.put(req_skills[i], i)
    }
    val p = IntArray(n)
    for (i in 0 until n) {
      for (s in people[i]) {
        p[i] = p[i] or (1 shl d[s]!!)
      }
    }
    val f = IntArray(1 shl m)
    val g = IntArray(1 shl m)
    val h = IntArray(1 shl m)
    val inf = 1 shl 30
    Arrays.fill(f, inf)
    f[0] = 0
    for (i in 0 until (1 shl m)) {
      if (f[i] == inf) {
        continue
      }
      for (j in 0 until n) {
        if (f[i] + 1 < f[i or p[j]]) {
          f[i or p[j]] = f[i] + 1
          g[i or p[j]] = j
          h[i or p[j]] = i
        }
      }
    }
    val ans: List<Int> = ArrayList()
    var i = (1 shl m) - 1
    while (i != 0) {
      ans.add(g[i])
      i = h[i]
    }
    return ans.stream().mapToInt(Integer::intValue).toArray()
  }
}

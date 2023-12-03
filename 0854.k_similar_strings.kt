internal class Solution {
  fun kSimilarity(s1: String?, s2: String): Int {
    val q: Deque<String> = ArrayDeque()
    val vis: Set<String> = HashSet()
    q.offer(s1)
    vis.add(s1)
    var ans = 0
    while (true) {
      for (i in q.size() downTo 1) {
        val s: String = q.pollFirst()
        if (s == s2) {
          return ans
        }
        for (nxt in next(s, s2)) {
          if (!vis.contains(nxt)) {
            vis.add(nxt)
            q.offer(nxt)
          }
        }
      }
      ++ans
    }
  }

  private fun next(s: String, s2: String): List<String> {
    var i = 0
    val n = s.length
    val cs = s.toCharArray()
    while (cs[i] == s2[i]) {
      ++i
    }
    val res: List<String> = ArrayList()
    for (j in i + 1 until n) {
      if (cs[j] == s2[i] && cs[j] != s2[j]) {
        swap(cs, i, j)
        res.add(String(cs))
        swap(cs, i, j)
      }
    }
    return res
  }

  private fun swap(cs: CharArray, i: Int, j: Int) {
    val t = cs[i]
    cs[i] = cs[j]
    cs[j] = t
  }
}

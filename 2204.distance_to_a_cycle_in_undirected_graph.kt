class Solution {
  fun distanceToCycle(n: Int, edges: Array<IntArray>): IntArray {
    val g: Array<Set<Int>?> = arrayOfNulls(n)
    Arrays.setAll(g) { k -> HashSet() }
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      g[a].add(b)
      g[b].add(a)
    }
    val q: Deque<Int> = ArrayDeque()
    for (i in 0 until n) {
      if (g[i]!!.size() === 1) {
        q.offer(i)
      }
    }
    val f = IntArray(n)
    val seq: Deque<Int> = ArrayDeque()
    while (!q.isEmpty()) {
      val i: Int = q.poll()
      seq.push(i)
      for (j in g[i]!!) {
        g[j].remove(i)
        f[i] = j
        if (g[j]!!.size() === 1) {
          q.offer(j)
        }
      }
    }
    val ans = IntArray(n)
    while (!seq.isEmpty()) {
      val i: Int = seq.pop()
      ans[i] = ans[f[i]] + 1
    }
    return ans
  }
}

internal class Solution {
  fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
    if (n == 1) {
      return Collections.singletonList(0)
    }
    val g: Array<List<Int>?> = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    val degree = IntArray(n)
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      g[a].add(b)
      g[b].add(a)
      ++degree[a]
      ++degree[b]
    }
    val q: Queue<Int> = LinkedList()
    for (i in 0 until n) {
      if (degree[i] == 1) {
        q.offer(i)
      }
    }
    val ans: List<Int> = ArrayList()
    while (!q.isEmpty()) {
      ans.clear()
      for (i in q.size() downTo 1) {
        val a: Int = q.poll()
        ans.add(a)
        for (b in g[a]!!) {
          if (--degree[b] == 1) {
            q.offer(b)
          }
        }
      }
    }
    return ans
  }
}

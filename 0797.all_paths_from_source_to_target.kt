internal class Solution {
  fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
    val n = graph.size
    val queue: Queue<List<Int>> = ArrayDeque()
    queue.offer(Arrays.asList(0))
    val ans: List<List<Int>> = ArrayList()
    while (!queue.isEmpty()) {
      val path: List<Int> = queue.poll()
      val u = path[path.size() - 1]
      if (u == n - 1) {
        ans.add(path)
        continue
      }
      for (v in graph[u]) {
        val next: List<Int> = ArrayList(path)
        next.add(v)
        queue.offer(next)
      }
    }
    return ans
  }
}

import kotlin.math.max

internal class Solution {
  fun minimumTime(n: Int, relations: Array<IntArray>, time: IntArray): Int {
    val g: Array<List<Int>?> = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    val indeg = IntArray(n)
    for (e in relations) {
      val a = e[0] - 1
      val b = e[1] - 1
      g[a].add(b)
      ++indeg[b]
    }
    val q: Deque<Int> = ArrayDeque()
    val f = IntArray(n)
    var ans = 0
    for (i in 0 until n) {
      val v = indeg[i]
      val t = time[i]
      if (v == 0) {
        q.offer(i)
        f[i] = t
        ans = max(ans.toDouble(), t.toDouble()).toInt()
      }
    }
    while (!q.isEmpty()) {
      val i: Int = q.pollFirst()
      for (j in g[i]!!) {
        f[j] = max(f[j].toDouble(), (f[i] + time[j]).toDouble()).toInt()
        ans = max(ans.toDouble(), f[j].toDouble()).toInt()
        if (--indeg[j] == 0) {
          q.offer(j)
        }
      }
    }
    return ans
  }
}

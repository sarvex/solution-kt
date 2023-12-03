import kotlin.math.max
import kotlin.math.min

class Solution {
  fun minReverseOperations(n: Int, p: Int, banned: IntArray, k: Int): IntArray {
    val ans = IntArray(n)
    val ts: Array<TreeSet<Int>> = arrayOf<TreeSet>(TreeSet(), TreeSet())
    for (i in 0 until n) {
      ts[i % 2].add(i)
      ans[i] = if (i == p) 0 else -1
    }
    ts[p % 2].remove(p)
    for (i in banned) {
      ts[i % 2].remove(i)
    }
    ts[0].add(n)
    ts[1].add(n)
    val q: Deque<Int> = ArrayDeque()
    q.offer(p)
    while (!q.isEmpty()) {
      val i: Int = q.poll()
      val mi = max((i - k + 1).toDouble(), (k - i - 1).toDouble()).toInt()
      val mx = min((i + k - 1).toDouble(), (n * 2 - k - i - 1).toDouble()).toInt()
      val s: TreeSet<Int> = ts[mi % 2]
      var j: Int = s.ceiling(mi)
      while (j <= mx) {
        q.offer(j)
        ans[j] = ans[i] + 1
        s.remove(j)
        j = s.ceiling(mi)
      }
    }
    return ans
  }
}

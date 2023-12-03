import java.util.*
import kotlin.collections.ArrayDeque

internal class Solution {
  fun rearrangeString(s: String, k: Int): String {
    val n = s.length
    val cnt = IntArray(26)
    for (c in s.toCharArray()) {
      ++cnt[c.code - 'a'.code]
    }
    val pq: PriorityQueue<IntArray> = PriorityQueue { a, b -> b.get(0) - a.get(0) }
    for (i in 0..25) {
      if (cnt[i] > 0) {
        pq.offer(intArrayOf(cnt[i], i))
      }
    }
    val q: Deque<IntArray> = ArrayDeque()
    val ans = StringBuilder()
    while (!pq.isEmpty()) {
      var p: Unit = pq.poll()
      val v: Int = p.get(0)
      val c: Int = p.get(1)
      ans.append(('a'.code + c).toChar())
      q.offer(intArrayOf(v - 1, c))
      if (q.size() >= k) {
        p = q.pollFirst()
        if (p[0] > 0) {
          pq.offer(p)
        }
      }
    }
    return if (ans.length == n) ans.toString() else ""
  }
}

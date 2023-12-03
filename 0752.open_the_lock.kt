internal class Solution {
  private var start: String? = null
  private var target: String? = null
  private val s: Set<String> = HashSet()
  fun openLock(deadends: Array<String?>, target: String): Int {
    if ("0000" == target) {
      return 0
    }
    start = "0000"
    this.target = target
    for (d in deadends) {
      s.add(d)
    }
    return if (s.contains(start)) {
      -1
    } else bfs()
  }

  private fun bfs(): Int {
    val m1: Map<String, Int> = HashMap()
    val m2: Map<String, Int> = HashMap()
    val q1: Deque<String> = ArrayDeque()
    val q2: Deque<String> = ArrayDeque()
    m1.put(start, 0)
    m2.put(target, 0)
    q1.offer(start)
    q2.offer(target)
    while (!q1.isEmpty() && !q2.isEmpty()) {
      val t = if (q1.size() <= q2.size()) extend(m1, m2, q1) else extend(m2, m1, q2)
      if (t != -1) {
        return t
      }
    }
    return -1
  }

  private fun extend(m1: Map<String, Int>, m2: Map<String, Int>, q: Deque<String>): Int {
    for (n in q.size() downTo 1) {
      val p: String = q.poll()
      val step = m1[p]!!
      for (t in next(p)) {
        if (m1.containsKey(t) || s.contains(t)) {
          continue
        }
        if (m2.containsKey(t)) {
          return step + 1 + m2[t]!!
        }
        m1.put(t, step + 1)
        q.offer(t)
      }
    }
    return -1
  }

  private fun next(t: String): List<String> {
    val res: List = ArrayList()
    val chars = t.toCharArray()
    for (i in 0..3) {
      val c = chars[i]
      chars[i] = if (c == '0') '9' else (c.code - 1).toChar()
      res.add(String(chars))
      chars[i] = if (c == '9') '0' else (c.code + 1).toChar()
      res.add(String(chars))
      chars[i] = c
    }
    return res
  }
}

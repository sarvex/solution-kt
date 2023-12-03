internal class Solution {
  private var words: Set<String>? = null
  fun ladderLength(beginWord: String?, endWord: String, wordList: List<String?>?): Int {
    words = HashSet(wordList)
    if (!words.contains(endWord)) {
      return 0
    }
    val q1: Queue<String> = ArrayDeque()
    val q2: Queue<String> = ArrayDeque()
    val m1: Map<String, Int> = HashMap()
    val m2: Map<String, Int> = HashMap()
    q1.offer(beginWord)
    q2.offer(endWord)
    m1.put(beginWord, 0)
    m2.put(endWord, 0)
    while (!q1.isEmpty() && !q2.isEmpty()) {
      val t = if (q1.size() <= q2.size()) extend(m1, m2, q1) else extend(m2, m1, q2)
      if (t != -1) {
        return t + 1
      }
    }
    return 0
  }

  private fun extend(m1: Map<String, Int>, m2: Map<String, Int>, q: Queue<String>): Int {
    for (i in q.size() downTo 1) {
      val s: String = q.poll()
      val step = m1[s]!!
      val chars = s.toCharArray()
      for (j in chars.indices) {
        val ch = chars[j]
        var k = 'a'
        while (k <= 'z') {
          chars[j] = k
          val t = String(chars)
          if (!words!!.contains(t) || m1.containsKey(t)) {
            ++k
            continue
          }
          if (m2.containsKey(t)) {
            return step + 1 + m2[t]!!
          }
          q.offer(t)
          m1.put(t, step + 1)
          ++k
        }
        chars[j] = ch
      }
    }
    return -1
  }
}

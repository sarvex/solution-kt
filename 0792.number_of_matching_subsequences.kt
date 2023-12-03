internal class Solution {
  fun numMatchingSubseq(s: String, words: Array<String>): Int {
    val d: Array<Deque<IntArray>?> = arrayOfNulls<Deque>(26)
    Arrays.setAll(d) { k -> ArrayDeque() }
    for (i in words.indices) {
      d[words[i][0].code - 'a'.code].offer(intArrayOf(i, 0))
    }
    var ans = 0
    for (c in s.toCharArray()) {
      val q: Deque<IntArray>? = d[c.code - 'a'.code]
      for (t in q.size() downTo 1) {
        val p: Unit = q.pollFirst()
        val i: Int = p.get(0)
        val j: Int = p.get(1) + 1
        if (j == words[i].length) {
          ++ans
        } else {
          d[words[i][j].code - 'a'.code].offer(intArrayOf(i, j))
        }
      }
    }
    return ans
  }
}

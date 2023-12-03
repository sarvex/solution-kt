class Solution {
  fun longestDiverseString(a: Int, b: Int, c: Int): String {
    val pq: Queue<IntArray> = PriorityQueue { x, y -> y.get(1) - x.get(1) }
    if (a > 0) {
      pq.offer(intArrayOf('a'.code, a))
    }
    if (b > 0) {
      pq.offer(intArrayOf('b'.code, b))
    }
    if (c > 0) {
      pq.offer(intArrayOf('c'.code, c))
    }
    val sb = StringBuilder()
    while (pq.size() > 0) {
      val cur: IntArray = pq.poll()
      val n = sb.length
      if (n >= 2 && sb.codePointAt(n - 1) == cur[0] && sb.codePointAt(n - 2) == cur[0]) {
        if (pq.size() === 0) {
          break
        }
        val next: IntArray = pq.poll()
        sb.append(next[0].toChar())
        if (next[1] > 1) {
          next[1]--
          pq.offer(next)
        }
        pq.offer(cur)
      } else {
        sb.append(cur[0].toChar())
        if (cur[1] > 1) {
          cur[1]--
          pq.offer(cur)
        }
      }
    }
    return sb.toString()
  }
}

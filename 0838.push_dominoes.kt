class Solution {
  fun pushDominoes(dominoes: String): String {
    val n = dominoes.length
    val q: Deque<Int> = ArrayDeque()
    val time = IntArray(n)
    Arrays.fill(time, -1)
    val force: Array<List<Char>?> = arrayOfNulls(n)
    for (i in 0 until n) {
      force[i] = ArrayList()
    }
    for (i in 0 until n) {
      val f = dominoes[i]
      if (f != '.') {
        q.offer(i)
        time[i] = 0
        force[i].add(f)
      }
    }
    val ans = CharArray(n)
    Arrays.fill(ans, '.')
    while (!q.isEmpty()) {
      val i: Int = q.poll()
      if (force[i]!!.size() === 1) {
        ans[i] = force[i]!![0]
        val f = ans[i]
        val j = if (f == 'L') i - 1 else i + 1
        if (j >= 0 && j < n) {
          val t = time[i]
          if (time[j] == -1) {
            q.offer(j)
            time[j] = t + 1
            force[j].add(f)
          } else if (time[j] == t + 1) {
            force[j].add(f)
          }
        }
      }
    }
    return String(ans)
  }
}

internal class Solution

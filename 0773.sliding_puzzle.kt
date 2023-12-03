import kotlin.math.abs

internal class Solution {
  private val m = 2
  private val n = 3
  fun slidingPuzzle(board: Array<IntArray>): Int {
    var start = ""
    val end = "123450"
    var seq = ""
    for (i in 0 until m) {
      for (j in 0 until n) {
        start += board[i][j]
        if (board[i][j] != 0) {
          seq += board[i][j]
        }
      }
    }
    if (!check(seq)) {
      return -1
    }
    val q: PriorityQueue<Pair<Int, String>> = PriorityQueue(Comparator.comparingInt(Pair::getKey))
    val dist: Map<String, Int> = HashMap()
    dist.put(start, 0)
    q.offer(Pair(f(start), start))
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    while (!q.isEmpty()) {
      val state: String = q.poll().getValue()
      val step = dist[state]!!
      if (end == state) {
        return step
      }
      val p1 = state.indexOf("0")
      val i = p1 / n
      val j = p1 % n
      val s = state.toCharArray()
      for (k in 0..3) {
        val x = i + dirs[k]
        val y = j + dirs[k + 1]
        if (x >= 0 && x < m && y >= 0 && y < n) {
          val p2 = x * n + y
          swap(s, p1, p2)
          val next = String(s)
          if (!dist.containsKey(next) || dist[next]!! > step + 1) {
            dist.put(next, step + 1)
            q.offer(Pair(step + 1 + f(next), next))
          }
          swap(s, p1, p2)
        }
      }
    }
    return -1
  }

  private fun swap(arr: CharArray, i: Int, j: Int) {
    val t = arr[i]
    arr[i] = arr[j]
    arr[j] = t
  }

  private fun f(s: String): Int {
    var ans = 0
    for (i in 0 until m * n) {
      if (s[i] != '0') {
        val num = s[i].code - '1'.code
        (ans += abs((i / n - num / n).toDouble()) + abs((i % n - num % n).toDouble())).toInt()
      }
    }
    return ans
  }

  private fun check(s: String): Boolean {
    val n = s.length
    var cnt = 0
    for (i in 0 until n) {
      for (j in i + 1 until n) {
        if (s[i] > s[j]) {
          ++cnt
        }
      }
    }
    return cnt % 2 == 0
  }
}

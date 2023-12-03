internal class Solution {
  fun minStickers(stickers: Array<String>, target: String): Int {
    val q: Deque<Int> = ArrayDeque()
    q.offer(0)
    var ans = 0
    val n = target.length
    val vis = BooleanArray(1 shl n)
    vis[0] = true
    while (!q.isEmpty()) {
      for (t in q.size() downTo 1) {
        val state: Int = q.poll()
        if (state == (1 shl n) - 1) {
          return ans
        }
        for (s in stickers) {
          var nxt = state
          val cnt = IntArray(26)
          for (c in s.toCharArray()) {
            ++cnt[c.code - 'a'.code]
          }
          for (i in 0 until n) {
            val idx = target[i].code - 'a'.code
            if (nxt and (1 shl i) == 0 && cnt[idx] > 0) {
              nxt = nxt or (1 shl i)
              --cnt[idx]
            }
          }
          if (!vis[nxt]) {
            vis[nxt] = true
            q.offer(nxt)
          }
        }
      }
      ++ans
    }
    return -1
  }
}

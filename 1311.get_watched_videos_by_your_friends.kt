import java.util.*

class Solution {
  fun watchedVideosByFriends(
    watchedVideos: List<List<String?>>, friends: Array<IntArray>, id: Int, level: Int
  ): List<String> {
    var level = level
    val n = friends.size
    val vis = BooleanArray(n)
    val q: Deque<Int> = LinkedList()
    q.offerLast(id)
    vis[id] = true
    while (level-- > 0) {
      for (i in q.size() downTo 1) {
        val u = q.pollFirst()
        for (v in friends[u]) {
          if (!vis[v]) {
            q.offerLast(v)
            vis[v] = true
          }
        }
      }
    }
    val freq: Map<String?, Int> = HashMap()
    while (!q.isEmpty()) {
      for (w in watchedVideos[q.pollFirst()]) {
        freq.put(w, (freq[w] ?: 0) + 1)
      }
    }
    val t: List<Map.Entry<String, Int>> = ArrayList(freq.entrySet())
    t.sort { a, b ->
      if (a.getValue() > b.getValue()) {
        return@sort 1
      }
      if (a.getValue() < b.getValue()) {
        return@sort -1
      }
      a.getKey().compareTo(b.getKey())
    }
    val ans: List<String> = ArrayList()
    for (e in t) {
      ans.add(e.getKey())
    }
    return ans
  }
}

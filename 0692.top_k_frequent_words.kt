internal class Solution {
  fun topKFrequent(words: Array<String>, k: Int): List<String> {
    val cnt: Map<String, Int> = HashMap()
    for (v in words) {
      cnt.put(v, (cnt[v] ?: 0) + 1)
    }
    val q: PriorityQueue<String> = PriorityQueue { a, b ->
      val d = cnt[a]!! - cnt[b]!!
      if (d == 0) b.compareTo(a) else d
    }
    for (v in cnt.keySet()) {
      q.offer(v)
      if (q.size() > k) {
        q.poll()
      }
    }
    val ans: LinkedList<String> = LinkedList()
    while (!q.isEmpty()) {
      ans.addFirst(q.poll())
    }
    return ans
  }
}

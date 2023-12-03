class Solution {
  fun findMaximumElegance(items: Array<IntArray>, k: Int): Long {
    Arrays.sort(items) { a, b -> b.get(0) - a.get(0) }
    val n = items.size
    var tot: Long = 0
    val vis: Set<Int> = HashSet()
    val dup: Deque<Int> = ArrayDeque()
    for (i in 0 until k) {
      val p = items[i][0]
      val c = items[i][1]
      tot += p.toLong()
      if (!vis.add(c)) {
        dup.push(p)
      }
    }
    var ans: Long = tot + vis.size() as Long * vis.size()
    for (i in k until n) {
      val p = items[i][0]
      val c = items[i][1]
      if (vis.contains(c) || dup.isEmpty()) {
        continue
      }
      vis.add(c)
      tot += p - dup.pop()
      ans = Math.max(ans, tot + vis.size() as Long * vis.size())
    }
    return ans
  }
}

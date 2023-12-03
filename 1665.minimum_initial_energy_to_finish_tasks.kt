class Solution {
  fun minimumEffort(tasks: Array<IntArray>): Int {
    Arrays.sort(tasks) { a, b -> a.get(0) - b.get(0) - (a.get(1) - b.get(1)) }
    var ans = 0
    var cur = 0
    for (task in tasks) {
      val a = task[0]
      val m = task[1]
      if (cur < m) {
        ans += m - cur
        cur = m
      }
      cur -= a
    }
    return ans
  }
}

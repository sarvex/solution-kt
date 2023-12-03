class Solution {
  fun findMinimumTime(tasks: Array<IntArray>): Int {
    Arrays.sort(tasks) { a, b -> a.get(1) - b.get(1) }
    val vis = IntArray(2010)
    var ans = 0
    for (task in tasks) {
      val start = task[0]
      val end = task[1]
      var duration = task[2]
      for (i in start..end) {
        duration -= vis[i]
      }
      var i = end
      while (i >= start && duration > 0) {
        if (vis[i] == 0) {
          --duration
          vis[i] = 1
          ans += vis[i]
        }
        --i
      }
    }
    return ans
  }
}

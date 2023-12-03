class Solution {
  fun taskSchedulerII(tasks: IntArray, space: Int): Long {
    val day: Map<Int, Long> = HashMap()
    var ans: Long = 0
    for (task in tasks) {
      ++ans
      ans = Math.max(ans, day[task] ?: 0L)
      day.put(task, ans + space + 1)
    }
    return ans
  }
}

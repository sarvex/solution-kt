class Solution {
  fun minProcessingTime(processorTime: List<Int>, tasks: List<Int>): Int {
    processorTime.sort { a, b -> a - b }
    tasks.sort { a, b -> a - b }
    var ans = 0
    var i: Int = tasks.size() - 1
    for (t in processorTime) {
      ans = Math.max(ans, t + tasks[i])
      i -= 4
    }
    return ans
  }
}

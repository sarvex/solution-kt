class Solution {
  fun maximumPopulation(logs: Array<IntArray>): Int {
    val d = IntArray(101)
    val offset = 1950
    for (log in logs) {
      val a = log[0] - offset
      val b = log[1] - offset
      ++d[a]
      --d[b]
    }
    var s = 0
    var mx = 0
    var j = 0
    for (i in d.indices) {
      s += d[i]
      if (mx < s) {
        mx = s
        j = i
      }
    }
    return j + offset
  }
}
